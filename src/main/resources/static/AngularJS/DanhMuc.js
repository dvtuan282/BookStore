var app = angular.module("danhMuc", [])
app.controller("danhMuc-ctrl", function ($scope, $http) {
    const url = "http://localhost:8080/K-Book/admin/danh-muc"
    var getUrlWithId = function (id) {
        return url + "/" + id;
    }
    //    chi tiet
    $scope.findByIdDM = function (id) {
        var urlWithId = getUrlWithId(id);
        $http.get(urlWithId).then(function (res) {
            const danhMuc = res.data;
            $scope.tenDanhMuc = danhMuc.tenDanhMuc;
            $scope.id = danhMuc.id;
        });
    }
    $scope.updateDM = function (id) {
        var urlWithId = getUrlWithId(id)
        var danhMuc = {
            tenDanhMuc: $scope.tenDanhMuc
        }
        $http.put(urlWithId, danhMuc).then(function (resp) {
            alert("Update success");
            location.reload();
        })
    }
});
