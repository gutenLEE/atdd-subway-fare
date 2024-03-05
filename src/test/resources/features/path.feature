Feature: 지하철 경로 검색

  Scenario: 두 역의 최소 시간 경로를 조회
    Given 지하철역이 등록되어있음
      |  이호선      |    오호선   |
      |  시청       |  뚝섬       |
      |  을지로입구   |  성수       |
      |  을지로3가   |  충정로   |
      |  을지로4가   |  서대문   |
      |  동대문역사문화공원   |  광화문   |
      |  신당       |  종로3가   |
      |  상왕십리      |  을지로4가   |
      |  왕십리      |  동대문역사문화공원   |
      |  한양대   |  청구   |
      |            |  신금호   |
      |            |  행당   |
      |            |  왕십리    |
      |            |  마장   |
    And 지하철 노선이 등록되어있음
    And 지하철 노선에 지하철역이 등록되어있음
      |   name  |   distance   |   duration   |
      |  이호선   |       10      |     1       |
      |  오호선   |       10      |     2       |
    When "을지로4가"에서 "왕십리"까지의 "DURATION" 기준으로 경로 조회를 요청
    Then 최소 시간 기준 경로인 "을지로4가,동대문역사문화공원,신당,상왕십리,왕십리"를 응답
    And 총 거리 20km와 소요 시간 4을 함께 응답함
    And 지하철 이용 요금 1450원도 함께 응답함