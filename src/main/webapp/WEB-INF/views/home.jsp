
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://kit.fontawesome.com/5081dee0c3.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap"
	rel="stylesheet" />
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<title>Exem</title>
<style type="text/css">
.table td, .table tr th {
	text-align: center;
}

.table_height {
	max-height: 700px;
	overflow-y: auto;
}
</style>
</head>

<body style="width: 80%; margin: 100px auto;">
	<div>
		<div class="d-grid gap-2">
			<button class="btn btn-lg btn-warning insertDustInfoBtn" type="button">JSON
				파일 읽어와서 DB에 저장하는 버튼</button>
			<p>JSON 파일을 읽고 DB에 저장하는데 시간이 소요됩니다. 알림창이 뜰 때 까지 잠시만 기다려주세요.</p>
		</div>
		<div class="insert_dust_info">
			<p>DB에 저장하는데 시간이 소요됩니다. 잠시만 기다려주세요.</p>
		</div>
	</div>
	<hr>
	<div>
		<div class="d-grid gap-2">
			<button class="btn btn-lg btn-warning insertRecordBtn" type="button">경보
				발령 정보 / 측정소 점검 내역 DB에 저장하는 버튼</button>
			<p>JSON 파일을 읽고 DB에 저장하는데 시간이 소요됩니다. 알림창이 뜰 때 까지 잠시만 기다려주세요.</p>
		</div>
		<div class="insert_record">
			<p>DB에 저장하는데 시간이 소요됩니다. 잠시만 기다려주세요.</p>
		</div>
	</div>
	<hr>
	<div>
		<h3>경보 발령 정보 확인하기</h3>
		<div style="display: flex; margin-bottom: 10px">
			<select class="form-select" id="alertCriteria">
				<option value="0">전체</option>
				<option value="1">1단계 : 초미세먼지 경보</option>
				<option value="2">2단계 : 미세먼지 경보</option>
				<option value="3">3단계 : 초미세먼지 주의보</option>
				<option value="4">4단계 : 미세먼지 주의보</option>
			</select> <select class="form-select" id="measurementStation">
				<option>전체</option>
				<option>강남구</option>
				<option>강동구</option>
				<option>강북구</option>
				<option>강서구</option>
				<option>관악구</option>
				<option>광진구</option>
				<option>구로구</option>
				<option>금천구</option>
				<option>노원구</option>
				<option>도봉구</option>
				<option>동대문구</option>
				<option>동작구</option>
				<option>마포구</option>
				<option>서대문구</option>
				<option>서초구</option>
				<option>성동구</option>
				<option>성북구</option>
				<option>송파구</option>
				<option>양천구</option>
				<option>영등포구</option>
				<option>용산구</option>
				<option>은평구</option>
				<option>종로구</option>
				<option>중구</option>
			</select>
			<button type="submit" class="btn btn-primary" id="searchBtn">Submit</button>
		</div>
		<div class="table_height">
			<table class="table table-hover">
				<thead class="table-dark">
					<tr>
						<th scope="col">측정소(구별)</th>
						<th scope="col">경보 단계</th>
						<th scope="col">발령 시간</th>
					</tr>
				</thead>
				<tbody class="select_record_result">

				</tbody>
			</table>
		</div>
	</div>
	<div style="margin-top : 30px;">
		<h3>측정소 점검 정보 확인하기</h3>
		<div style="display: flex; margin-bottom: 10px">
			<select class="form-select" id="inspectionStation">
				<option>전체</option>
				<option>강남구</option>
				<option>강동구</option>
				<option>강북구</option>
				<option>강서구</option>
				<option>관악구</option>
				<option>광진구</option>
				<option>구로구</option>
				<option>금천구</option>
				<option>노원구</option>
				<option>도봉구</option>
				<option>동대문구</option>
				<option>동작구</option>
				<option>마포구</option>
				<option>서대문구</option>
				<option>서초구</option>
				<option>성동구</option>
				<option>성북구</option>
				<option>송파구</option>
				<option>양천구</option>
				<option>영등포구</option>
				<option>용산구</option>
				<option>은평구</option>
				<option>종로구</option>
				<option>중구</option>
			</select>
			<button type="submit" class="btn btn-primary"
				id="inspectionSearchBtn">Submit</button>
		</div>
		<div class="table_height">
			<table class="table table-hover">
				<thead class="table-dark">
					<tr>
						<th scope="col">측정소(구별)</th>
						<th scope="col">PM10</th>
						<th scope="col">PM2_5</th>
						<th scope="col">점검 시간</th>
					</tr>
				</thead>
				<tbody class="select_inspection_record_result">

				</tbody>
			</table>
		</div>
	</div>


</body>
<script>
	$(function() {
		var insertDustInfoBtn = $('.insertDustInfoBtn');
		var insertRecordBtn = $('.insertRecordBtn');
		var searchBtn = $('#searchBtn');
		var inspectionSearchBtn = $('#inspectionSearchBtn');

		insertDustInfoBtn.click(function() {
			alert("데이터를 저장합니다. 시간이 오래 걸릴 수도 있습니다.");
			$.ajax({
				url : "insertDustInfo.moon",
				type : "GET",
				dataType : "json",
				error : function(xhr, status, msg) {
					console.log(status + "/" + msg);
				},
				success : function(json) {
					if (json.result == "dataInsertSuccess") {
						alert("데이터를 성공적으로 저장했습니다.");
						$('.insert_dust_info').html('데이터를 성공적으로 저장했습니다.');
					} else if (json.result == "dataExist") {
						alert("데이터가 이미 저장 되어있습니다.");
						$('.insert_dust_info').html('데이터가 이미 저장 되어있습니다.');
					} else {
						alert("실패했습니다. 다시 시도해주세요.");
					}
				}
			});

		})

		insertRecordBtn.click(function() {
			alert("데이터를 저장합니다. 시간이 오래 걸릴 수도 있습니다.");
			$.ajax({
				url : "insertRecord.moon",
				type : "GET",
				dataType : "json",
				error : function(xhr, status, msg) {
					console.log(status + "/" + msg);
				},
				success : function(json) {
					if (json.result == "dataInsertSuccess") {
						alert("데이터를 성공적으로 저장했습니다.");
						$('.insert_record').html('데이터를 성공적으로 저장했습니다.');
					} else if (json.result == "dataExist") {
						alert("데이터가 이미 저장 되어있습니다.");
						$('.insert_record').html('데이터가 이미 저장 되어있습니다.');
					} else {
						alert("실패했습니다. 다시 시도해주세요.");
					}
				}
			});

		})

		searchBtn.click(function() {
			var alertCriteria = $("#alertCriteria option:selected").val();
			var measurementStation = $("#measurementStation option:selected")
					.val();
			$.ajax({
				url : "selectRecord.moon",
				type : "GET",
				dataType : "json",
				error : function(xhr, status, msg) {
					console.log(status + "/" + msg);
				},
				data : {
					"alertCriteria" : alertCriteria,
					"measurementStation" : measurementStation,
				},
				success : function(json) {
					selectRecordResult(json);
					console.log(json);
				}
			});
		})

		function selectRecordResult(json) {
			$('.select_record_result').empty();
			$.each(json, function(idx, record) {
				$("<tr>").append(
						$("<td>").html(record.measurement_station_name))
						.append($("<td>").html(record.alert_level)).append(
								$("<td>").html(record.measurement_time))
						.appendTo(".select_record_result");
			});
		}

		inspectionSearchBtn.click(function() {
			var inspectionStation = $("#inspectionStation option:selected")
					.val();
			$.ajax({
				url : "selectInspectionRecord.moon",
				type : "GET",
				dataType : "json",
				error : function(xhr, status, msg) {
					console.log(status + "/" + msg);
				},
				data : {
					"inspectionStation" : inspectionStation,
				},
				success : function(json) {
					selectInspectionRecordResult(json);
					console.log(json);
				}
			});
		})

		function selectInspectionRecordResult(json) {
			$('.select_inspection_record_result').empty();
			$.each(json, function(idx, record) {
				$("<tr>").append(
						$("<td>").html(record.measurement_station_name))
						.append($("<td>").html(record.pm10)).append(
								$("<td>").html(record.pm2_5)).append(
								$("<td>").html(record.measurement_time))
						.appendTo(".select_inspection_record_result");
			});
		}

	})
</script>

</html>