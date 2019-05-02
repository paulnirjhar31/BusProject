 $(document).ready(function() {
	 $.ajax({url: "/BusProject/home", success: function(result){
			console.log(result);
		    var sourceList =result.SourceList;
			var destinationList = result.DestinationList;
			for(var i=0; i<sourceList.length;i++) {
			var option = $('<option/>');
			option.attr({ 'value': sourceList[i].id }).text(sourceList[i].cityName);
			$('#fromCity').append(option);
			}
			
			for(var i=0; i<destinationList.length;i++) {
				var option = $('<option/>');
				option.attr({ 'value': sourceList[i].id }).text(sourceList[i].cityName);
				$('#toCity').append(option);
			}
			
	}
});
	 
});