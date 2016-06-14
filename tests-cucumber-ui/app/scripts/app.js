(function (angular, appConfig) {
  'use strict';

  angular
    .module('testsCucumberApp', [
      'ngResource',
      'ngRoute',
      'ui.bootstrap',
      'ngFileUpload',
      'angular-loading-bar',
      'monospaced.elastic'
    ])
    .constant('baseUri', appConfig.apiBaseUri)
    .config(function ($compileProvider) {
      $compileProvider.debugInfoEnabled(appConfig.angularDebugMode || false);
    })
    .config(function ($routeProvider) {
      $routeProvider
        .otherwise({
          redirectTo: '/'
        });
    });

})(angular, configuration);
