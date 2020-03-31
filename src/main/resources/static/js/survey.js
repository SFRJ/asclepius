var survey = angular.module('survey', []);

var surveyDto = {
  age:"",
  sex:"",
  status:"",
  isChronic:"",
  isKeyWorker:""
};
//https://www.guru99.com/angularjs-ng-submit.html
survey.controller('surveyController', function($scope, $http) {

    $scope.sendAnswers = function() {

        $http(
                {
                    method: 'POST',
                    url: 'http://localhost:8080/surveys/new',
                    data: surveyDto,
                    headers: {'Content-Type': 'application/json;charset-UTF-8'}
                }
        );
    };
});