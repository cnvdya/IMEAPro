'use strict'
var module = angular.module('iepTracker.controllers', []);
module.controller("IEPController", ["$scope", "IEPService","$location","MainService","$rootScope","toastr",
    function($scope, IEPService, $location,MainService, $rootScope,toastr) {

        $scope.studentDto = {
            studentId: null,
            firstName: null,
            lastName: null,
            school: null,
            district: null,
            parent: null,
            dob: null,
            grade: null,
            gender: null
        };

        $scope.studentID = "103";

        $scope.studentDto.guardian={
            name: null,
            isPrimary: null,
            relation: null,
            contact: null

        };

        $scope.addStudent=function(){
            $location.url('/addStudent');
        };

        $scope.opendetails=function(studentID){
            MainService.studentID=103;
            $location.url('/details');
        };

        $scope.addGoal=function(){
            $location.url('/addGoal');
        };

        $scope.evaluationData = {
            "chart": {
                "caption": "Task Evaluation ",
                "subCaption": "split by date",
                "xAxisName": "Date",
                "yAxisName": "Task completed",
                "numberSuffix": "K",
                "theme": "fusion",
            },
            "data": [{
                "label": "Venezuela",
                "value": "290"
            }, {
                "label": "Saudi",
                "value": "260"
            }, {
                "label": "Canada",
                "value": "180"
            }, {
                "label": "Iran",
                "value": "140"
            }, {
                "label": "Russia",
                "value": "115"
            }, {
                "label": "UAE",
                "value": "100"
            }, {
                "label": "US",
                "value": "30"
            }, {
                "label": "China",
                "value": "30"
            }]
        };

        $scope.test1chartData={
            // Chart Configuration
            "chart": {
                "caption": "Average performance: Strategy 1",
                "lowerLimit": "0",
                "upperLimit": "100",
                "showValue": "1",
                "numberSuffix": "%",
                "theme": "fusion",
                "showToolTip": "0"
            },
            // Chart Data
            "colorRange": {
                "color": [{
                    "minValue": "0",
                    "maxValue": "50",
                    "code": "#F2726F"
                }, {
                    "minValue": "50",
                    "maxValue": "75",
                    "code": "#FFC533"
                }, {
                    "minValue": "75",
                    "maxValue": "100",
                    "code": "#62B58F"
                }]
            },
            "dials": {
                "dial": [{
                    "value": "59"
                }]
            }
        };

        $scope.test2chartData={
            // Chart Configuration
            "chart": {
                "caption": "Average performance: Strategy 2",
                "lowerLimit": "0",
                "upperLimit": "100",
                "showValue": "1",
                "numberSuffix": "%",
                "theme": "fusion",
                "showToolTip": "0"
            },
            // Chart Data
            "colorRange": {
                "color": [{
                    "minValue": "0",
                    "maxValue": "50",
                    "code": "#F2726F"
                }, {
                    "minValue": "50",
                    "maxValue": "75",
                    "code": "#FFC533"
                }, {
                    "minValue": "75",
                    "maxValue": "100",
                    "code": "#62B58F"
                }]
            },
            "dials": {
                "dial": [{
                    "value": "70"
                }]
            }
        };

        $scope.test3chartData={
            // Chart Configuration
            "chart": {
                "caption": "Average performance: Strategy 3",
                "lowerLimit": "0",
                "upperLimit": "100",
                "showValue": "1",
                "numberSuffix": "%",
                "theme": "fusion",
                "showToolTip": "0"
            },
            // Chart Data
            "colorRange": {
                "color": [{
                    "minValue": "0",
                    "maxValue": "50",
                    "code": "#F2726F"
                }, {
                    "minValue": "50",
                    "maxValue": "75",
                    "code": "#FFC533"
                }, {
                    "minValue": "75",
                    "maxValue": "100",
                    "code": "#62B58F"
                }]
            },
            "dials": {
                "dial": [{
                    "value": "93"
                }]
            }
        };

        $scope.ganttchartData={
            "chart": {
                "caption": "IEP Goals Progress Report",
                "subcaption": "Planned vs Actual",
                "dateformat": "dd/mm/yyyy",
                "outputdateformat": "ddds mns yy",
                "ganttwidthpercent": "60",
                "ganttPaneDuration": "40",
                "ganttPaneDurationUnit": "d",
                "plottooltext": "$processName{br} $label starting date $start{br}$label ending date $end",
                "legendBorderAlpha": "0",
                "flatScrollBars": "1",
                "gridbordercolor": "#333333",
                "gridborderalpha": "20",
                "slackFillColor": "#e44a00",
                "taskBarFillMix": "light+0",
                "theme": "fusion"
            },
            "categories": [
                {
                    "bgcolor": "#999999",
                    "category": [
                        {
                            "start": "1/4/2014",
                            "end": "30/6/2014",
                            "label": "Months",
                            "align": "middle",
                            "fontcolor": "#ffffff",
                            "fontsize": "12"
                        }
                    ]
                },
                {
                    "bgcolor": "#999999",
                    "align": "middle",
                    "fontcolor": "#ffffff",
                    "fontsize": "12",
                    "category": [
                        {
                            "start": "1/4/2014",
                            "end": "30/4/2014",
                            "label": "April"
                        },
                        {
                            "start": "1/5/2014",
                            "end": "31/5/2014",
                            "label": "May"
                        },
                        {
                            "start": "1/6/2014",
                            "end": "30/6/2014",
                            "label": "June"
                        }
                    ]
                },
                {
                    "bgcolor": "#ffffff",
                    "fontcolor": "#333333",
                    "fontsize": "11",
                    "align": "center",
                    "category": [
                        {
                            "start": "1/4/2014",
                            "end": "5/4/2014",
                            "label": "Week 1"
                        },
                        {
                            "start": "6/4/2014",
                            "end": "12/4/2014",
                            "label": "Week 2"
                        },
                        {
                            "start": "13/4/2014",
                            "end": "19/4/2014",
                            "label": "Week 3"
                        },
                        {
                            "start": "20/4/2014",
                            "end": "26/4/2014",
                            "label": "Week 4"
                        },
                        {
                            "start": "27/4/2014",
                            "end": "3/5/2014",
                            "label": "Week 5"
                        },
                        {
                            "start": "4/5/2014",
                            "end": "10/5/2014",
                            "label": "Week 6"
                        },
                        {
                            "start": "11/5/2014",
                            "end": "17/5/2014",
                            "label": "Week 7"
                        },
                        {
                            "start": "18/5/2014",
                            "end": "24/5/2014",
                            "label": "Week 8"
                        },
                        {
                            "start": "25/5/2014",
                            "end": "31/5/2014",
                            "label": "Week 9"
                        },
                        {
                            "start": "1/6/2014",
                            "end": "7/6/2014",
                            "label": "Week 10"
                        },
                        {
                            "start": "8/6/2014",
                            "end": "14/6/2014",
                            "label": "Week 11"
                        },
                        {
                            "start": "15/6/2014",
                            "end": "21/6/2014",
                            "label": "Week 12"
                        },
                        {
                            "start": "22/6/2014",
                            "end": "28/6/2014",
                            "label": "Week 13"
                        }
                    ]
                }
            ],
            "processes": {
                "headertext": "Task",
                "fontcolor": "#000000",
                "fontsize": "11",
                "isanimated": "1",
                "bgcolor": "#6baa01",
                "headervalign": "bottom",
                "headeralign": "left",
                "headerbgcolor": "#999999",
                "headerfontcolor": "#ffffff",
                "headerfontsize": "12",
                "align": "left",
                "isbold": "1",
                "bgalpha": "25",
                "process": [
                    {
                        "label": "Orientation Session",
                        "id": "1"
                    },
                    {
                        "label": "Student Enrollment",
                        "id": "2",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "Setting Goals",
                        "id": "3",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "Set task and Objective",
                        "id": "4",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "IEP meeting, round 1",
                        "id": "5",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "Evaluation 1",
                        "id": "6",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "Evaluation 2",
                        "id": "7"
                    },
                    {
                        "label": "Review Feedback",
                        "id": "8"
                    },
                    {
                        "label": "IEP meeting, round 2",
                        "id": "9",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "Evaluation 3",
                        "id": "10",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "Mid-term IEP Meeting ",
                        "id": "11"
                    },
                    {
                        "label": "Evaluation 4",
                        "id": "12"
                    },
                    {
                        "label": "Review Mid-term Feedback ",
                        "id": "13"
                    },
                    {
                        "label": "Revise Quarterly Goals",
                        "id": "14"
                    },
                    {
                        "label": "Set Objectives",
                        "id": "15"
                    },
                    {
                        "label": "Plan Annual Outing",
                        "id": "16"
                    },
                    {
                        "label": "Complete Tasks for Final Evaluation",
                        "id": "17",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "Final Evaluation",
                        "id": "18",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "Review Feedback",
                        "id": "19",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "Schedule IEP Meeting",
                        "id": "20"
                    },
                    {
                        "label": "Revising Goals",
                        "id": "21",
                        "hoverBandColor": "#e44a00",
                        "hoverBandAlpha": "40"
                    },
                    {
                        "label": "Final IEP Meeting",
                        "id": "22"
                    }
                ]
            },
            "datatable": {
                "showprocessname": "1",
                "namealign": "left",
                "fontcolor": "#000000",
                "fontsize": "10",
                "valign": "right",
                "align": "center",
                "headervalign": "bottom",
                "headeralign": "center",
                "headerbgcolor": "#999999",
                "headerfontcolor": "#ffffff",
                "headerfontsize": "12",
                "datacolumn": [
                    {
                        "bgcolor": "#eeeeee",
                        "headertext": "Actual{br}Start{br}Date",
                        "text": [
                            {
                                "label": "9/4/2014"
                            },
                            {
                                "label": "13/4/2014"
                            },
                            {
                                "label": "26/4/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "4/5/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "6/5/2014"
                            },
                            {
                                "label": "5/5/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "11/5/2014"
                            },
                            {
                                "label": "16/5/2014"
                            },
                            {
                                "label": "16/5/2014"
                            },
                            {
                                "label": "21/5/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "25/5/2014"
                            },
                            {
                                "label": "28/5/2014"
                            },
                            {
                                "label": "4/6/2014"
                            },
                            {
                                "label": "4/6/2014"
                            },
                            {
                                "label": "4/6/2014"
                            },
                            {
                                "label": "2/6/2014"
                            },
                            {
                                "label": "5/6/2014"
                            },
                            {
                                "label": "18/6/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "16/6/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "23/6/2014"
                            },
                            {
                                "label": "18/6/2014"
                            },
                            {
                                "label": "25/6/2014"
                            }
                        ]
                    },
                    {
                        "bgcolor": "#eeeeee",
                        "headertext": "Actual{br}End{br}Date",
                        "text": [
                            {
                                "label": "12/4/2014"
                            },
                            {
                                "label": "25/4/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "4/5/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "10/5/2014"
                            },
                            {
                                "label": "10/5/2014"
                            },
                            {
                                "label": "11/5/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "14/5/2014"
                            },
                            {
                                "label": "19/5/2014"
                            },
                            {
                                "label": "21/5/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "24/5/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "27/5/2014"
                            },
                            {
                                "label": "1/6/2014"
                            },
                            {
                                "label": "6/6/2014"
                            },
                            {
                                "label": "4/6/2014"
                            },
                            {
                                "label": "4/6/2014"
                            },
                            {
                                "label": "7/6/2014"
                            },
                            {
                                "label": "17/6/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "20/6/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "23/6/2014"
                            },
                            {
                                "label": "23/6/2014"
                            },
                            {
                                "label": "23/6/2014",
                                "bgcolor": "#e44a00",
                                "bgAlpha": "40"
                            },
                            {
                                "label": "28/6/2014"
                            }
                        ]
                    }
                ]
            },
            "tasks": {
                "task": [
                    {
                        "label": "Planned",
                        "processid": "1",
                        "start": "9/4/2014",
                        "end": "12/4/2014",
                        "id": "1-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "1",
                        "start": "9/4/2014",
                        "end": "12/4/2014",
                        "id": "1",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "2",
                        "start": "13/4/2014",
                        "end": "23/4/2014",
                        "id": "2-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "2",
                        "start": "13/4/2014",
                        "end": "25/4/2014",
                        "id": "2",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Delay",
                        "processid": "2",
                        "start": "23/4/2014",
                        "end": "25/4/2014",
                        "id": "2-2",
                        "color": "#e44a00",
                        "toppadding": "56%",
                        "height": "32%",
                        "tooltext": "Delayed by 2 days."
                    },
                    {
                        "label": "Planned",
                        "processid": "3",
                        "start": "23/4/2014",
                        "end": "30/4/2014",
                        "id": "3-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "3",
                        "start": "26/4/2014",
                        "end": "4/5/2014",
                        "id": "3",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Delay",
                        "processid": "3",
                        "start": "3/5/2014",
                        "end": "4/5/2014",
                        "id": "3-2",
                        "color": "#e44a00",
                        "toppadding": "56%",
                        "height": "32%",
                        "tooltext": "Delayed by 1 days."
                    },
                    {
                        "label": "Planned",
                        "processid": "4",
                        "start": "3/5/2014",
                        "end": "10/5/2014",
                        "id": "4-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "4",
                        "start": "4/5/2014",
                        "end": "10/5/2014",
                        "id": "4",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "5",
                        "start": "6/5/2014",
                        "end": "11/5/2014",
                        "id": "5-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "5",
                        "start": "6/5/2014",
                        "end": "10/5/2014",
                        "id": "5",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "6",
                        "start": "4/5/2014",
                        "end": "7/5/2014",
                        "id": "6-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "6",
                        "start": "5/5/2014",
                        "end": "11/5/2014",
                        "id": "6",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Delay",
                        "processid": "6",
                        "start": "7/5/2014",
                        "end": "11/5/2014",
                        "id": "6-2",
                        "color": "#e44a00",
                        "toppadding": "56%",
                        "height": "32%",
                        "tooltext": "Delayed by 4 days."
                    },
                    {
                        "label": "Planned",
                        "processid": "7",
                        "start": "11/5/2014",
                        "end": "14/5/2014",
                        "id": "7-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "7",
                        "start": "11/5/2014",
                        "end": "14/5/2014",
                        "id": "7",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "8",
                        "start": "16/5/2014",
                        "end": "19/5/2014",
                        "id": "8-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "8",
                        "start": "16/5/2014",
                        "end": "19/5/2014",
                        "id": "8",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "9",
                        "start": "16/5/2014",
                        "end": "18/5/2014",
                        "id": "9-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "9",
                        "start": "16/5/2014",
                        "end": "21/5/2014",
                        "id": "9",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Delay",
                        "processid": "9",
                        "start": "18/5/2014",
                        "end": "21/5/2014",
                        "id": "9-2",
                        "color": "#e44a00",
                        "toppadding": "56%",
                        "height": "32%",
                        "tooltext": "Delayed by 3 days."
                    },
                    {
                        "label": "Planned",
                        "processid": "10",
                        "start": "20/5/2014",
                        "end": "23/5/2014",
                        "id": "10-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "10",
                        "start": "21/5/2014",
                        "end": "24/5/2014",
                        "id": "10",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Delay",
                        "processid": "10",
                        "start": "23/5/2014",
                        "end": "24/5/2014",
                        "id": "10-2",
                        "color": "#e44a00",
                        "toppadding": "56%",
                        "height": "32%",
                        "tooltext": "Delayed by 1 days."
                    },
                    {
                        "label": "Planned",
                        "processid": "11",
                        "start": "25/5/2014",
                        "end": "27/5/2014",
                        "id": "11-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "11",
                        "start": "25/5/2014",
                        "end": "27/5/2014",
                        "id": "11",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "12",
                        "start": "28/5/2014",
                        "end": "1/6/2014",
                        "id": "12-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "12",
                        "start": "28/5/2014",
                        "end": "1/6/2014",
                        "id": "12",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "13",
                        "start": "4/6/2014",
                        "end": "6/6/2014",
                        "id": "13-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "13",
                        "start": "4/6/2014",
                        "end": "6/6/2014",
                        "id": "13",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "14",
                        "start": "4/6/2014",
                        "end": "4/6/2014",
                        "id": "14-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "14",
                        "start": "4/6/2014",
                        "end": "4/6/2014",
                        "id": "14",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "15",
                        "start": "4/6/2014",
                        "end": "4/6/2014",
                        "id": "15-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "15",
                        "start": "4/6/2014",
                        "end": "4/6/2014",
                        "id": "15",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "16",
                        "start": "2/6/2014",
                        "end": "7/6/2014",
                        "id": "16-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "16",
                        "start": "2/6/2014",
                        "end": "7/6/2014",
                        "id": "16",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "17",
                        "start": "5/6/2014",
                        "end": "10/6/2014",
                        "id": "17-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "17",
                        "start": "5/6/2014",
                        "end": "17/6/2014",
                        "id": "17",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Delay",
                        "processid": "17",
                        "start": "10/6/2014",
                        "end": "17/6/2014",
                        "id": "17-2",
                        "color": "#e44a00",
                        "toppadding": "56%",
                        "height": "32%",
                        "tooltext": "Delayed by 7 days."
                    },
                    {
                        "label": "Planned",
                        "processid": "18",
                        "start": "10/6/2014",
                        "end": "12/6/2014",
                        "id": "18-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Delay",
                        "processid": "18",
                        "start": "18/6/2014",
                        "end": "20/6/2014",
                        "id": "18",
                        "color": "#e44a00",
                        "toppadding": "56%",
                        "height": "32%",
                        "tooltext": "Delayed by 8 days."
                    },
                    {
                        "label": "Planned",
                        "processid": "19",
                        "start": "15/6/2014",
                        "end": "23/6/2014",
                        "id": "19-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "19",
                        "start": "16/6/2014",
                        "end": "23/6/2014",
                        "id": "19",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "20",
                        "start": "23/6/2014",
                        "end": "23/6/2014",
                        "id": "20-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "20",
                        "start": "23/6/2014",
                        "end": "23/6/2014",
                        "id": "20",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Planned",
                        "processid": "21",
                        "start": "18/6/2014",
                        "end": "21/6/2014",
                        "id": "21-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "21",
                        "start": "18/6/2014",
                        "end": "23/6/2014",
                        "id": "21",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    },
                    {
                        "label": "Delay",
                        "processid": "21",
                        "start": "21/6/2014",
                        "end": "23/6/2014",
                        "id": "21-2",
                        "color": "#e44a00",
                        "toppadding": "56%",
                        "height": "32%",
                        "tooltext": "Delayed by 2 days."
                    },
                    {
                        "label": "Planned",
                        "processid": "22",
                        "start": "24/6/2014",
                        "end": "28/6/2014",
                        "id": "22-1",
                        "color": "#008ee4",
                        "height": "32%",
                        "toppadding": "12%"
                    },
                    {
                        "label": "Actual",
                        "processid": "22",
                        "start": "25/6/2014",
                        "end": "28/6/2014",
                        "id": "22",
                        "color": "#6baa01",
                        "toppadding": "56%",
                        "height": "32%"
                    }
                ]
            },
            "connectors": [
                {
                    "connector": [
                        {
                            "fromtaskid": "1",
                            "totaskid": "2",
                            "color": "#008ee4",
                            "thickness": "2",
                            "fromtaskconnectstart_": "1"
                        },
                        {
                            "fromtaskid": "2-2",
                            "totaskid": "3",
                            "color": "#008ee4",
                            "thickness": "2"
                        },
                        {
                            "fromtaskid": "3-2",
                            "totaskid": "4",
                            "color": "#008ee4",
                            "thickness": "2"
                        },
                        {
                            "fromtaskid": "3-2",
                            "totaskid": "6",
                            "color": "#008ee4",
                            "thickness": "2"
                        },
                        {
                            "fromtaskid": "7",
                            "totaskid": "8",
                            "color": "#008ee4",
                            "thickness": "2"
                        },
                        {
                            "fromtaskid": "7",
                            "totaskid": "9",
                            "color": "#008ee4",
                            "thickness": "2"
                        },
                        {
                            "fromtaskid": "12",
                            "totaskid": "16",
                            "color": "#008ee4",
                            "thickness": "2"
                        },
                        {
                            "fromtaskid": "12",
                            "totaskid": "17",
                            "color": "#008ee4",
                            "thickness": "2"
                        },
                        {
                            "fromtaskid": "17-2",
                            "totaskid": "18",
                            "color": "#008ee4",
                            "thickness": "2"
                        },
                        {
                            "fromtaskid": "19",
                            "totaskid": "22",
                            "color": "#008ee4",
                            "thickness": "2"
                        }
                    ]
                }
            ],
            "milestones": {
                "milestone": [
                    {
                        "date": "2/6/2014",
                        "taskid": "12",
                        "color": "#f8bd19",
                        "shape": "star",
                        "tooltext": "Completion of Phase 1"
                    }
                ]
            },
            "legend": {
                "item": [
                    {
                        "label": "Planned",
                        "color": "#008ee4"
                    },
                    {
                        "label": "Actual",
                        "color": "#6baa01"
                    },
                    {
                        "label": "Slack (Delay)",
                        "color": "#e44a00"
                    }
                ]
            }
        };

        $scope.linechartData={
            "chart": {
                "caption": "Attendance for past 7 days",
                "subCaption": "Last week",
                "xAxisName": "Day",
                "yAxisName": "No. of Students",
                "lineThickness": "2",
                "theme": "fusion"
            },
            "data": [
                {
                    "label": "Mon",
                    "value": "9"
                },
                {
                    "label": "Tue",
                    "value": "11"
                },
                {
                    "label": "Wed",
                    "value": "8"
                },
                {
                    "label": "Thu",
                    "value": "10"
                },
                {
                    "label": "Fri",
                    "value": "8"
                },

            ],
            "trendlines": [
                {
                    "line": [
                        {
                            "startvalue": "9",
                            "color": "#1aaf5d",
                            "displayvalue": "Average{br}weekly{br}attendance",
                            "valueOnRight": "1",
                            "thickness": "2"
                        }
                    ]
                }
            ]
        };

        $scope.heatmapdata={
            "chart": {
                "caption": "Classes that students enjoy most",
                "subcaption": "By Strategies",
                "xAxisName": "Strategies",
                "yAxisName": "Objective",
                "plottooltext": "<div id='nameDiv' style='font-size: 12px; border-bottom: 1px dashed #666666; font-weight:bold; padding-bottom: 3px; margin-bottom: 5px; display: inline-block; color: #888888;' >$rowLabel :</div>{br}Rating : <b>$dataValue</b>{br}$columnLabel : <b>$tlLabel</b>{br}<b>$trLabel</b>",
                "theme": "fusion"
            },
            "rows": {
                "row": [
                    {
                        "id": "SGS5",
                        "label": "Words Pronunciation"
                    },
                    {
                        "id": "HTC1M8",
                        "label": "Social Behavious"
                    },
                    {
                        "id": "IPHONES5",
                        "label": "Object Identification"
                    },
                    {
                        "id": "LUMIA",
                        "label": "Counting - Maths"
                    }
                ]
            },
            "columns": {
                "column": [
                    {
                        "id": "processor",
                        "label": "Cartoon Video Clips"
                    },
                    {
                        "id": "screen",
                        "label": "Interactive Session - Deeplens"
                    },
                    {
                        "id": "price",
                        "label": "Team Building Activity"
                    },
                    {
                        "id": "backup",
                        "label": "Board Game"
                    },
                    {
                        "id": "cam",
                        "label": "Singing"
                    }
                ]
            },
            "dataset": [
                {
                    "data": [
                        {
                            "rowid": "SGS5",
                            "columnid": "processor",
                            "value": "8.7",
                            "tllabel": "Quad Core 2.5 GHz",
                            "trlabel": "OS : Android 4.4 Kitkat"
                        },
                        {
                            "rowid": "SGS5",
                            "columnid": "screen",
                            "value": "8.5",
                            "tllabel": "5.1 inch",
                            "trlabel": "AMOLED screen"
                        },
                        {
                            "rowid": "SGS5",
                            "columnid": "price",
                            "value": "9.3",
                            "tllabel": "$600"
                        },
                        {
                            "rowid": "SGS5",
                            "columnid": "backup",
                            "value": "9.7",
                            "tllabel": "29 Hrs",
                            "trlabel": "Battery : 2800 MAH"
                        },
                        {
                            "rowid": "SGS5",
                            "columnid": "cam",
                            "value": "8",
                            "tllabel": "16 MP",
                            "trlabel": "Front Camera : 2.1 MP"
                        },
                        {
                            "rowid": "HTC1M8",
                            "columnid": "processor",
                            "value": "9.2",
                            "tllabel": "Quad Core 2.3 GHz",
                            "trlabel": "OS : Android 4.4 Kitkat"
                        },
                        {
                            "rowid": "HTC1M8",
                            "columnid": "screen",
                            "value": "8.3",
                            "tllabel": "5 inch",
                            "trlabel": "LCD screen"
                        },
                        {
                            "rowid": "HTC1M8",
                            "columnid": "price",
                            "value": "7.3",
                            "tllabel": "$600"
                        },
                        {
                            "rowid": "HTC1M8",
                            "columnid": "backup",
                            "value": "8.8",
                            "tllabel": "20 Hrs",
                            "trlabel": "Battery : 2600 MAH"
                        },
                        {
                            "rowid": "HTC1M8",
                            "columnid": "cam",
                            "value": "8.7",
                            "tllabel": "4 MP",
                            "trlabel": "Front Camera : 5 MP"
                        },
                        {
                            "rowid": "IPHONES5",
                            "columnid": "processor",
                            "value": "9.1",
                            "tllabel": "Dual Core",
                            "trlabel": "OS : iOS 7"
                        },
                        {
                            "rowid": "IPHONES5",
                            "columnid": "screen",
                            "value": "8.6",
                            "tllabel": "4 inch",
                            "trlabel": "Retina LCD screen"
                        },
                        {
                            "rowid": "IPHONES5",
                            "columnid": "price",
                            "value": "7.2",
                            "tllabel": "$649"
                        },
                        {
                            "rowid": "IPHONES5",
                            "columnid": "backup",
                            "value": "8.4",
                            "tllabel": "10 Hrs",
                            "trlabel": "Battery : 1560 MAH"
                        },
                        {
                            "rowid": "IPHONES5",
                            "columnid": "cam",
                            "value": "9.5",
                            "tllabel": "8 MP",
                            "trlabel": "Front Camera : 1.2 MP"
                        },
                        {
                            "rowid": "LUMIA",
                            "columnid": "processor",
                            "value": "8.8",
                            "tllabel": "Quad Core 2.2 GHz",
                            "trlabel": "OS: Windows Phone 8"
                        },
                        {
                            "rowid": "LUMIA",
                            "columnid": "screen",
                            "value": "9.1",
                            "tllabel": "6 inch",
                            "trlabel": "LCD screen"
                        },
                        {
                            "rowid": "LUMIA",
                            "columnid": "price",
                            "value": "9.7",
                            "tllabel": "$470"
                        },
                        {
                            "rowid": "LUMIA",
                            "columnid": "backup",
                            "value": "9.2",
                            "tllabel": "27 Hrs",
                            "trlabel": "Battery : 3400 MAH"
                        },
                        {
                            "rowid": "LUMIA",
                            "columnid": "cam",
                            "value": "8.1",
                            "tllabel": "20MP",
                            "trlabel": "Front Camera : 1.2 MP"
                        }
                    ]
                }
            ],
            "colorrange": {
                "gradient": "0",
                "minvalue": "0",
                "code": "E24B1A",
                "startlabel": "Poor",
                "endlabel": "Good",
                "color": [
                    {
                        "code": "E24B1A",
                        "minvalue": "1",
                        "maxvalue": "5",
                        "label": "Bad"
                    },
                    {
                        "code": "F6BC33",
                        "minvalue": "5",
                        "maxvalue": "8.5",
                        "label": "Average"
                    },
                    {
                        "code": "6DA81E",
                        "minvalue": "8.5",
                        "maxvalue": "10",
                        "label": "Good"
                    }
                ]
            }
        };


        $scope.addRow = function(){
            // create a blank array
            var newrow = [];

            // if array is blank add a standard item
            if ($scope.data.length === 0) {
                newrow = [{'en':''}];
            } else {
                // else cycle thru the first row's columns
                // and add the same number of items
                $scope.data[0].forEach(function (row) {
                    newrow.push({'en':''});
                });
                $scope.data[1].forEach(function (row) {
                    newrow.push({'en':''});
                });
            }
            // add the new row at the end of the array
            $scope.data.push(newrow);
        };



        $scope.studentList={};

        IEPService.getAllStudents().then(function(value) {
            console.log(value.data);
            $scope.studentList=value.data;
        }, function(reason) {
            console.log("error occured");
        }, function(value) {
            console.log("no callback");
        });



        }


    ]);


module.controller("StudentController", ["$scope", "IEPService","$location","MainService","$rootScope","toastr",
    function($scope, IEPService, $location, MainService, $rootScope, toastr) {

    $scope.studentDto={};
    $scope.goals={};
    $scope.defaultPanel=MainService.defaultPanel;

        $scope.init = function () {

            $scope.getStudentById();
            $scope.getGoalsList();
        };


        $scope.getStudentById = function(){
            IEPService.getStudentById(MainService.studentID).then(function(value) {
                console.log("student data",value.data);
                $scope.studentDto=value.data;
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });

        };



        $scope.getGoalsList = function(){
            IEPService.getGoalsbyStudentId(MainService.studentID).then(function(value) {
                console.log(value.data);
                $scope.goals=value.data;
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });

        };


        $scope.$on('goalListUpdated',function(event,data){
            $scope.getGoalsList();

        });


        $scope.studentList={};

        $scope.getStudentslist = function(){
            IEPService.getAllStudents().then(function(value) {
                console.log(value.data);
                $scope.studentList=value.data;
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });


        };







        $scope.addNewObjective = function() {
            var newItemNo = $scope.studentDto.guardians.length+1;
            $scope.studentDto.guardians.push({'id' : 'choice' + newItemNo, 'name' : 'choice' + newItemNo});
        };

        $scope.removeNewObjective = function() {
            var newItemNo = $scope.studentDto.guardians.length-1;
            if ( newItemNo !== 0 ) {
                $scope.studentDto.guardians.pop();
            }
        };




        $scope.showAddObjective = function(objective) {
            return objective.id === $scope.studentDto.guardians[$scope.studentDto.guardians.length-1].id;
        };

        $scope.updateStudent=function(){
            console.log("student update function called", $scope.studentDto.studentID);
            MainService.studentID=$scope.studentDto.studentID;
            $scope.getStudentById();
            $location.url('/addStudent');
        };


        $scope.opendetails=function(){
            $location.url('/details');
        };

        $scope.addGoal=function(){
            MainService.goalID=null;
            $location.url('/addGoal');
        };




        $scope.addRow = function(){
            // create a blank array
            var newrow = [];

            // if array is blank add a standard item
            if ($scope.data.length === 0) {
                newrow = [{'en':''}];
            } else {
                // else cycle thru the first row's columns
                // and add the same number of items
                $scope.data[0].forEach(function (row) {
                    newrow.push({'en':''});
                });
                $scope.data[1].forEach(function (row) {
                    newrow.push({'en':''});
                });
            }
            // add the new row at the end of the array
            $scope.data.push(newrow);
        };





        $scope.saveStudent = function() {
            IEPService.saveStudent($scope.studentDto).then(function() {
                console.log("works");
                $location.url('/details');
                toastr.success("Student saved successfully !");
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        };


        $scope.getGoalById = function(goalID){
            MainService.goalID=goalID;
            $location.url('/goalDetail');
        };





        $scope.updateRow = function(row){

            $scope.openUpdatePopup=function(){
                $rootScope.modalInstance=$uibModal.open({
                    templateUrl:'Modules/file/updateFile.html',
                    controller:'FileUpdateController',
                    resolve: {
                        rowData: function() {
                            return row
                        }
                    }
                });
            };
            $scope.openUpdatePopup();
        }


    }


]);


module.controller("GoalController", ["$scope","$interval","$uibModal", "$location","$rootScope","MainService","IEPService","toastr",
    function($scope,$interval,$uibModal,  $location,  $rootScope,MainService, IEPService, toastr) {

    $scope.goalData=null;
    $scope.goalID=MainService.goalID;
    $scope.tasks={};
    $scope.determinateValue=50;

    $scope.totaltasks=0;
    $scope.completedtasks=0;
    $scope.percentage=0;

    $scope.notStarted=true;
    $scope.inprogress=false;
    $scope.completed=false;

    $scope.init=function(){
        $scope.getTasksList();
        $scope.getGoalData();
    };

    $scope.goal={};
        $scope.goal.studentID=MainService.studentID;
        $scope.objectivesList = ["Emil", "Tobias", "Linus"];
        $scope.selectedObjective = $scope.objectivesList[0];


        $scope.goal.objectiveDtoList = [{objectiveID: '', objectiveDescription: '', startDate: '', completionDate: ''}];


        $scope.addNewObjective = function() {
            var newItemNo = $scope.goal.objectiveDtoList.length+1;
            $scope.goal.objectiveDtoList.push({'id' : 'choice' + newItemNo, 'name' : 'choice' + newItemNo});
        };

        $scope.removeNewObjective = function() {
            var newItemNo = $scope.goal.objectiveDtoList.length-1;
            if ( newItemNo !== 0 ) {
                $scope.goal.objectiveDtoList.pop();
            }
        };




        $scope.showAddObjective = function(objective) {
            return objective.id === $scope.goal.objectiveDtoList[$scope.goal.objectiveDtoList.length-1].id;
        };



        $scope.addnewgoal = function() {
            console.log($scope.goal);
            IEPService.saveGoal($scope.goal).then(function() {
                MainService.goalListUpdate();
                console.log("works");
                MainService.defaultPanel="goalList";
                $location.url('/details');
                toastr.success("New goal added successfully !");
                // IEPService.getAllStudents().then(function(value) {
                //     $scope.allStudents = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });
        };

        $scope.openAddTaskPopup=function(){
            console.log("opening popup");
            $rootScope.modalInstance=$uibModal.open({
                templateUrl:'addTask',
                controller:'TaskController',
                controllerAs : "vm"
            });
        };

        $scope.openAddEvaluationPopup=function(){
            console.log("opening popup");
            $rootScope.modalInstance=$uibModal.open({
                templateUrl:'addEvaluation',
                controller:'EvaluationController',
                controllerAs : "vm"
            });
        };



        $scope.getGoalData = function(){
            IEPService.getGoalById($scope.goalID).then(function(value){
                console.log("get goal by ID worked");
                console.log(value.data);
                $scope.goalData = value.data;
                $scope.goal=$scope.goalData;
            },function(reason) {
                console.log("error occured");
            },function(value) {
                console.log("no callback");
            });

        };



        $scope.getTasksList = function(){
            IEPService.getTasksByGoalId($scope.goalID).then(function(value){
                console.log("get tasks by goal ID worked");
                console.log(value.data);
                $scope.tasks = value.data;

                angular.forEach($scope.tasks, function(value, key) {
                    console.log("totalinside"+value.evaluationTotal);
                    console.log("completedinside"+value.evaluationCompleted);
                    $scope.totaltasks=$scope.totaltasks+value.evaluationTotal;
                    $scope.completedtasks=$scope.completedtasks+value.evaluationCompleted;
                });
                console.log("total"+$scope.totaltasks);
                console.log("completed"+$scope.completedtasks);
                $scope.percentage=$scope.completedtasks*100/$scope.totaltasks;
                if($scope.percentage==100){
                    $scope.statusComplete();
                }
                else if ($scope.percentage<100 && $scope.percentage>0){
                    $scope.statusInProgress();
                }
                else{
                    $scope.statusNotStarted();
                }
            },function(reason) {
                console.log("error occured");
            },function(value) {
                console.log("no callback");
            });

        };

        $scope.updateGoal=function(){
            console.log($scope.goalData.goalID);
            console.log(MainService.goalID);
            MainService.goalID=$scope.goalData.goalID;
            $scope.getGoalData();
            $location.url('/addGoal');
        };




        $scope.$on('taskListUpdated',function(event,data){
            $scope.getTasksList();

        });

        $scope.getTaskById = function(taskID){
            MainService.taskID=taskID;
            $location.url('/taskDetails');
        };

        $scope.statusInProgress = function() {
            $scope.notStarted=false;
            $scope.inprogress=true;
            $scope.completed=false;
        };

        $scope.statusComplete = function() {
            $scope.notStarted=false;
            $scope.inprogress=false;
            $scope.completed=true;
        };

        $scope.statusNotStarted = function() {
            $scope.notStarted=true;
            $scope.inprogress=false;
            $scope.completed=false;
        };


    }

]);




    module.controller("TaskController", ["$scope","$uibModal", "$location","$rootScope","MainService","IEPService","toastr","$uibModalInstance",
        function($scope,$uibModal,  $location,  $rootScope,MainService, IEPService, toastr,$uibModalInstance) {

            var vm = this;
            vm.task={};
            vm.selectedObjective={};
            vm.objectivesList = {};
            vm.goalID=IEPService.goalID;


            IEPService.getObjectivesByGoalId(vm.goalID).then(function(value){
                console.log("get objectives by goal ID worked");
                console.log(value.data);
                vm.objectivesList = value.data;
            },function(reason) {
                console.log("error occured");
            },function(value) {
                console.log("no callback");
            });


            vm.dismiss = function(){
                $uibModalInstance.dismiss();
            };

            vm.close = function(){
                $uibModalInstance.close();
            };


            $scope.addNewTask = function() {
                vm.task.objectiveID=vm.selectedObjective.objectiveID;
                vm.task.goalID=vm.goalID;
                vm.task.notStarted=1;
                console.log($scope.task);
                IEPService.saveTask(vm.task).then(function() {
                    MainService.taskListUpdate();
                    console.log("works");
                    vm.dismiss();
                    toastr.success("New task added successfully !");
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });
            }


        }
]);

module.controller("EvaluationController", ["$scope","$uibModal", "$location","$rootScope","MainService","IEPService","toastr","$uibModalInstance",
    function($scope,$uibModal,  $location,  $rootScope,MainService, IEPService, toastr,$uibModalInstance) {

        var vm = this;
        vm.evaluation={};
        vm.goalID=MainService.goalID;
        vm.goalData={};
        vm.strategies=["Team Activity","Smart Interactive Session","Writing","Reading","Audio aids","Visual aids","Audio and visual aids"];
        vm.selectedStrategy={};
        vm.myDate = new Date();
        vm.isOpen = false;

        vm.tasksList = {};
        vm.selectedTask={};

        vm.dismiss = function(){
            $uibModalInstance.dismiss();
        };

        vm.close = function(){
            $uibModalInstance.close();
        };


        IEPService.getTasksByGoalId(vm.goalID).then(function(value){
            console.log("get tasks by goal ID worked");
            console.log(value.data);
            vm.tasksList = value.data;
        },function(reason) {
            console.log("error occured");
        },function(value) {
            console.log("no callback");
        });

        IEPService.getGoalById(vm.goalID).then(function(value){
            console.log("get goal by ID worked");
            console.log(value.data);
            vm.goalData = value.data;
        },function(reason) {
            console.log("error occured");
        },function(value) {
            console.log("no callback");
        });

        $scope.addNewEvaluation = function() {
            vm.evaluation.taskID=vm.selectedTask.taskID;
            vm.evaluation.goalID=vm.goalID;
            vm.evaluation.strategyUsed=vm.selectedStrategy;
            console.log(vm.evaluation);
            IEPService.saveEvaluation(vm.evaluation).then(function() {
                MainService.taskListUpdate();
                vm.dismiss();
                toastr.success("Evaluation completed successfully !");
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }




    }
]);


module.controller("TaskDetailController", ["$scope","$uibModal", "$location","$rootScope","MainService","IEPService","toastr",
    function($scope,$uibModal,  $location,  $rootScope,MainService, IEPService, toastr) {

        $scope.evaluations={};
        $scope.taskData={};
        $scope.taskID=MainService.taskID;

        $scope.init=function(){
            $scope.taskID=MainService.taskID;
            $scope.getTaskByID();
            $scope.getEvaluationListByTaskId();
        };

        $scope.totalEvaluations = null;
        $scope.completedEvaluations = null;
        $scope.percentage=0;
        $scope.notStarted=true;
        $scope.inprogress=false;
        $scope.completed=false;

        $scope.getTaskByID = function(){
            IEPService.getTaskByID($scope.taskID).then(function(value){
                console.log("get task by task ID worked");
                console.log(value.data);
                $scope.taskData = value.data;
            },function(reason) {
                console.log("error occured");
            },function(value) {
                console.log("no callback");
            });

        };

        $scope.getEvaluationListByTaskId = function(){
            IEPService.getEvaluationListByTaskId($scope.taskID).then(function(value){
                $scope.evaluations = value.data;
                $scope.totalEvaluations = $scope.taskData.evaluationTotal;
                angular.forEach($scope.evaluations, function(value, key) {
                    if (value.passed == 1) {
                        $scope.completedEvaluations=$scope.completedEvaluations+1;
                    }
                });
                $scope.percentage=$scope.completedEvaluations * 100 /$scope.totalEvaluations;
                if($scope.percentage==100){
                    $scope.statusComplete();
                }
                else if ($scope.percentage<100 && $scope.percentage>0){
                    $scope.statusInProgress();
                }
                else{
                    $scope.statusNotStarted();
                }
            },function(reason) {
                console.log("error occured");
            },function(value) {
                console.log("no callback");
            });

        };


        $scope.statusInProgress = function() {
            $scope.notStarted=false;
            $scope.inprogress=true;
            $scope.completed=false;
        };

        $scope.statusComplete = function() {
            $scope.notStarted=false;
            $scope.inprogress=false;
            $scope.completed=true;
        };

        $scope.statusNotStarted = function() {
            $scope.notStarted=true;
            $scope.inprogress=false;
            $scope.completed=false;
        };

    }
]);



