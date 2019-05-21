
'use strict'
var iepTrackerApp = angular.module('iepTracker',
    ['ui.bootstrap',
        'ngRoute',
        'iepTracker.controllers',
        'iepTracker.services',
        'ng-fusioncharts',
        'toastr',
        'ngMaterial',
        'ngMessages'
]);




iepTrackerApp.config(function($routeProvider,$locationProvider,$mdThemingProvider) {

    $routeProvider.when('/home', {
        templateUrl: 'dashboard'
    });
    $routeProvider.when('/addStudent', {
        templateUrl: 'addStudent'
    });
    $routeProvider.when('/studentsview', {
        templateUrl: 'studentsview'
    });
    $routeProvider.when('/details', {
        templateUrl: 'details'
    });
    $routeProvider.when('/addGoal', {
        templateUrl: 'addGoal'
    });
    $routeProvider.when('/goalDetail', {
        templateUrl: 'goalDetail'
    });
    $routeProvider.when('/taskDetails', {
        templateUrl: 'taskDetails'
    });
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
});


iepTrackerApp.constant("CONSTANTS", {
    getStudentByIdUrl: "/student/getstudent/",
    getAllStudents: "/student/getallstudents",
    saveStudent: "/student/savestudent",
    saveGoal: "/student/savegoal",
    viewGoalsByStudentId: "/student/getgoals",
    viewGoalById: "/student/getgoal",
    viewObjectivesByGoalId:"/student/getobjectives",
    saveTask:"/student/savetask",
    viewTasksById:"/student/gettasks",
    saveEvaluation:"/student/saveevaluation",
    getTaskByID:"/student/gettask",
    getEvaluationListByTaskId:"/student/getevaluations"
});

// var datePicker = angular.module('app', []);

iepTrackerApp.directive(function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attrs, ngModelCtrl) {
            element.datepicker({
                dateFormat: 'DD, d  MM, yy',
                onSelect: function (date) {
                    scope.date = date;
                    scope.$apply();
                }
            });
        }
    };
});

