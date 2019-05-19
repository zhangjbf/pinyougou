app.controller("contentController", function ($scope, contentService) {
    $scope.contentList = [];
    // 根据分类ID查询广告的方法:
    $scope.findByCategoryId = function (categoryId) {
        contentService.findByCategoryId(categoryId).success(function (response) {
            $scope.contentList[categoryId] = response;
        });
    }

    //搜索  （传递参数）
    $scope.search = function () {
        if (!$scope.keywords) {
            location.href = "http://192.168.1.112:8084/search.html#";
        } else {
            location.href = "http://192.168.1.112:8084/search.html#?keywords=" + $scope.keywords;
        }
    }

});