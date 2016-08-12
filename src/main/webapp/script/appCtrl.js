app.controller('myCtrl',function($scope,$http){
		
	var url='http://localhost:8092/ParallelProjectFMS/ViewAllActors';
	
	$http.get(url)
		.success(function(response){
			console.log(response);
			$scope.actors=response;
		});
	
	var url='http://localhost:8092/ParallelProjectFMS/ViewAllFilms';
	
	$http.get(url)
		.success(function(response){
			console.log(response);
			$scope.films=response;
		});
	
	
	});


