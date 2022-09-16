<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StudyCafe</title>

</head>
<body>
	
	
	  <div style="width: 500px; height: 400px;"></div>
	  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f139139b38bf971967e652426af47ff9"></script>
	  <script>
		  var container = document.getElementById('map');
		  var options = {
			  center: new kakao.maps.LatLng(33.450701, 126.570667),
			  level: 3
		  };
  
		  var map = new kakao.maps.Map(container, options);
	  </script>
	
	
</body>
</html>