var app = angular.module("tacGia", [])
app.controller("tacGia-ctrl", function ($scope, $http) {
    const url = "http://localhost:8080/K-Book/admin/tac-gia"
    var getUrlWithId = function (id) {
        return url + "/" + id;
    }
    //    chi tiet
    $scope.findById = function (id) {
        var urlWithId = getUrlWithId(id);
        $http.get(urlWithId).then(function (res) {
            const danhMuc = res.data;
            $scope.tenTacGia = danhMuc.tenTacGia;
            $scope.id = danhMuc.id;
        });
    }
    $scope.update = function (id) {
        var urlWithId = getUrlWithId(id)
        var danhMuc = {
            tenTacGia: $scope.tenTacGia
        }
        $http.put(urlWithId, danhMuc).then(function (resp) {
            alert("Update success");
            location.reload();
        })
    }
});