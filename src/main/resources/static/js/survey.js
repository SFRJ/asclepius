var survey = angular.module('survey', []);

var surveyDto = {
  age:"",
  sex:"",
  status:"",
  isChronic:"",
  isKeyWorker:"",
  isIsolating:""
};

survey.controller('surveyController', function($scope, $http) {

    $scope.submit = function() {

        $http(
            method: 'POST',
            url: 'http://localhost:8080/add',
            data: surveyDto,
            headers: {'Content-Type': 'application/json;charset-UTF-8'}
        );

    };
});