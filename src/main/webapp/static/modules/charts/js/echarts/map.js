$(function () {
	var mapChart = echarts.init(document.getElementById("echarts-map-chart"));
	var coldCar = [
	    {
	        "name": "车辆1",
	        "value": [107.615944, 27.479744, 2]
	    },
	    {
	        "name": "车辆2",
	        "value": [108.296644, 27.676476, 2]
	    }
	]
	$.get('http://localhost:8080/jbxq_tzdb/static/modules/map/json/320100.json', function (geoJson) {
		console.log(geoJson);
		echarts.registerMap('CHINA', geoJson,{
			MultiPolygon:{
				left: -131,
	            top: 25,
	            width: 15
			}
		});
		mapChart.setOption({
			tooltip:{
				show:true,
				trigger:'item',
				triggerOn:'click',
				formatter:'名称'
			},
	        series: [{
	            type: 'map',
	            map: 'CHINA'
	        }]
	    });

	})
});