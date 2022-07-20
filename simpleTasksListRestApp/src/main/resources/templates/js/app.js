let TasksListApp = angular.module('TasksListApp',[]);
//let identity = 1;

TasksListApp.controller('TaskListController', function($scope, $http){

    $http.get("http://localhost:8080/api/v1/tasks/all")
        .then(resp => {
            $scope.tasksItems = resp.data;
        },
        resp => {
            console.error(resp);
        })

    $scope.description = '';
//    $scope.tasksItems = {};

    $scope.create  = function(description){

        $http.post("http://localhost:8080/api/v1/tasks", {'description' : description})
            .then(resp =>{
                $scope.tasksItems[resp.data.id] = resp.data;
                $scope.description = '';
           },
           resp => {
                console.error(resp);
           })

//        let id = identity++;
//        $scope.tasksItems[id] = {id: id, description: description};

    }
    $scope.delete = function(item){
        $http.delete("http://localhost:8080/api/v1/tasks/" + item.id)
            .then(resp =>{
                delete $scope.tasksItems[item.id];
            },
            resp => {
                console.error(resp);
           })
    }
});

