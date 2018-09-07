<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<style type="text/css">
		#nested-loader-wrapper {
			position: fixed;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index:1000;
			//background-color: red;
		}
		#nested-loader.loading {
			display: block;
			position: relative;
			left: 50%;
			top: 50%;
			width: 150px;
			height: 150px;
			margin: -75px 0 0 -75px;
			//border: 1px red solid;
			border-radius: 50%;
			border: 3px solid transparent;
			border-top-color: #3498db;
			
			-webkit-animation: spin 2s linear infinite; /* Chrome, Opera 15+, Safari 5+ */
          animation: spin 2s linear infinite; /* Chrome, Firefox 16+, IE 10+, Opera */
		}
		#nested-loader.loading:before {
			content: "";
			position: absolute;
			top: 5px;
			left: 5px;
			right: 5px;
			bottom: 5px;
			border-radius: 50%;
			border: 3px solid transparent; 
			border-top-color: #e74c3c;
			
			-webkit-animation: spin 3s linear infinite; /* Chrome, Opera 15+, Safari 5+ */
          animation: spin 3 s linear infinite; /* Chrome, Firefox 16+, IE 10+, Opera */
		}
		#nested-loader.loading:after {
			content: "";
			position: absolute;
			top: 15px;
			left: 15px;
			right: 15px;
			bottom: 15px;
			border-radius: 50%; 
			border: 3px solid transparent;
			border-top-color: #f9c922;
			
			-webkit-animation: spin 1.5s linear infinite; /* Chrome, Opera 15+, Safari 5+ */
          animation: spin 1.5s linear infinite; /* Chrome, Firefox 16+, IE 10+, Opera */ 
		}
		@-webkit-keyframes spin {
			0% {
				-webkit-transform: rotate(0deg);  /* Chrome, Opera 15+, Safari 3.1+ */
				-ms-transform: rotate(0deg);  /* IE 9 */
				transform: rotate(0deg);  /* Firefox 16+, IE 10+, Opera*/ 
			}
			100% {
				-webkit-transform: rotate(360deg);  /* Chrome, Opera 15+, Safari 3.1+ */
				-ms-transform: rotate(360deg);  /* IE 9 */
				transform: rotate(360deg);  /* Firefox 16+, IE 10+, Opera*/
			}
		}
		@keyframes spin {
			0% {
				-webkit-transform: rotate(0deg);  /* Chrome, Opera 15+, Safari 3.1+ */
				-ms-transform: rotate(0deg);  /* IE 9 */
				transform: rotate(0deg);  /* Firefox 16+, IE 10+, Opera*/ 
			}
			100% {
				-webkit-transform: rotate(360deg);  /* Chrome, Opera 15+, Safari 3.1+ */
				-ms-transform: rotate(360deg);  /* IE 9 */
				transform: rotate(360deg);  /* Firefox 16+, IE 10+, Opera*/
			}
		}
	</style>
</head>
<body>
	<div id="nested-loader-wrapper">
		<div id="nested-loader" class="loading">
		</div>
	</div>

</body>
</html>