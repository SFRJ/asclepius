var survey = angular.module('survey', []);

var surveyDto = {
  age:"",
  sex:"",
  status:"",
  isChronic:"",
  isKeyWorker:""
};

survey.controller('surveyController', function($scope, $http) {

    $scope.sendAnswers = function(surveyDto) {

        $http(
                {
                    method: 'POST',
                    url: 'http://localhost:8080/surveys/new',
                    data: surveyDto,
                    headers: {'Content-Type': 'application/json'}
                }
        );
    };
});