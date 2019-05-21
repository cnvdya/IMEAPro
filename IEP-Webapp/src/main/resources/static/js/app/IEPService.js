'use strict'
angular.module('iepTracker.services', [])

    .factory('IEPService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.getStudentById = function(studentId) {
        var url = CONSTANTS.getStudentByIdUrl + "?studentId="+studentId;
        return $http.get(url);
    };
    service.getAllStudents = function() {
        return $http.get(CONSTANTS.getAllStudents);
    };
    service.saveStudent = function(studentDto) {
        return $http.post(CONSTANTS.saveStudent, studentDto);
    };
    service.saveGoal = function(goal) {
        return $http.post(CONSTANTS.saveGoal, goal);
    };
    service.getGoalsbyStudentId = function(studentId){
        var url = CONSTANTS.viewGoalsByStudentId + "?studentId="+studentId;
        return $http.get(url);
    };
    service.getGoalById = function(goalId){
        var url = CONSTANTS.viewGoalById + "?goalId="+goalId;
        return $http.get(url);
    };
    service.getObjectivesByGoalId = function(goalId){
            var url = CONSTANTS.viewObjectivesByGoalId + "?goalId="+goalId;
            return $http.get(url);
    };
    service.saveTask = function(task) {
        return $http.post(CONSTANTS.saveTask, task);
    };
    service.getTasksByGoalId=function(goalId){
        var url = CONSTANTS.viewTasksById + "?goalId="+goalId;
        return $http.get(url);
    };
    service.saveEvaluation=function(evaluation) {
        return $http.post(CONSTANTS.saveEvaluation, evaluation);
    };
    service.getTaskByID=function(taskID) {
        var url = CONSTANTS.getTaskByID + "?taskID="+taskID;
        return $http.get(url);
    };
    service.getEvaluationListByTaskId=function(taskID) {
        var url = CONSTANTS.getEvaluationListByTaskId + "?taskID="+taskID;
        return $http.get(url);
    };

    return service;
}])

.service('MainService',function($rootScope){
    this.studentID=103;
    this.defaultPanel="studentDetail";
    this.goalID=null;
    this.taskID=null;

    this.taskListUpdate=function(){
        $rootScope.$broadcast('taskListUpdated','update list everywhere');
    };

    this.goalListUpdate=function(){
        $rootScope.$broadcast('goalListUpdated','update list everywhere');
    };

    // this.evaluationListUpdate=function(){
    //     $rootScope.$broadcast('evaluationListUpdated','update list everywhere');
    // };
    //
    // this.isLoggedin=false;
    // this.loggedUser={};
    // this.loginDetails=function(params){
    //     this.isLoggedin=params.isLoggedin;
    //     this.loggedUser.userID=params.userID;
    //     this.loggedUser.fName=params.firstname;
    //     this.loggedUser.lName=params.lastname;
    //     $rootScope.$broadcast('loginDetailsUpdated','update data everywhere');
    //     this.fileListUpdate();
    // }
    // this.fileListUpdate=function(){
    //     $rootScope.$broadcast('fileListUpdated','update list everywhere');
    // }
});