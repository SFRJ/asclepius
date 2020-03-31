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
                    url: 'http://localhost:8080/add',
                    data: surveyDto,
                    headers: {'Content-Type': 'application/json;charset-UTF-8'}
                }
        ).subscribe(
                 (val) => {
                     console.log("POST call successful value returned in body",
                                 val);
                 },
                 response => {
                     console.log("POST call in error", response);
                 },
                 () => {
                     console.log("The POST observable is now completed.");
                 });
    };
});