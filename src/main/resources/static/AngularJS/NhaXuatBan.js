var app = angular.module("nxb", [])
app.controller("nxb-ctrl", function ($scope, $http) {
    const url = "http://localhost:8080/K-Book/admin/nha-xuat-ban"
    var getUrlWithId = function (id) {
        return url + "/" + id;
    }
    //    chi tiet
    $scope.findById = function (id) {
        var urlWithId = getUrlWithId(id);
        $http.get(urlWithId).then(function (res) {
            const nhaXuatBan = res.data;
            $scope.tenNXB = nhaXuatBan.tenNhaXuatBan;
            $scope.id = nhaXuatBan.id;
        });
    }
    $scope.update = function (id) {
        var urlWithId = getUrlWithId(id)
        var danhMuc = {
            tenNhaXuatBan: $scope.tenNXB
        }
        $http.put(urlWithId, danhMuc).then(function (resp) {
            alert("Update success");
            location.reload();
        })
    }
});