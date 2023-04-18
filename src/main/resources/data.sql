INSERT INTO `emart`.`user` (`id`, `address`, `email`, `name`, `password`, `role`) VALUES ('1', '경기도 성남시','admin@gmail.com', '관리자', '1234**qq', '관리자');
INSERT INTO `emart`.`user` (`id`, `address`, `email`, `name`, `password`, `role`) VALUES ('2', '부산시 수영구', 'soo@gmail.com', '김철수', '1234**qq', '일반회원');
INSERT INTO `emart`.`user` (`id`, `address`, `email`, `name`, `password`, `role`) VALUES ('3', '경상남도 김해시', 'hee@gmail.com', '김영희', '1234**qq', '일반회원');
INSERT INTO `emart`.`user` (`id`, `address`, `email`, `name`, `password`, `role`) VALUES ('4', '서울시 강남구', 'dog@gmail.com', '김바둑', '1234**qq', '일반회원');

INSERT INTO `emart`.`product` (`id`, `brand`, `category`, `description`, `discount`, `name`, `price`, `rating`, `thumbnail`) VALUES ('1', '롯데제과', '크래커', '초콜릿가공품, 대륙식품(주) 덕계공장 경남 양산시 그린공단3길 108 (한국), 원산지: 상세설명참조', '0', '롯데 빈츠 2입 리미티드기획 408g', '5370', '4.8', 'https://sitem.ssgcdn.com/59/56/18/item/1000530185659_i1_1100.jpg');
INSERT INTO `emart`.`product` (`id`, `brand`, `category`, `description`, `discount`, `name`, `price`, `rating`, `thumbnail`) VALUES ('2', '네슬레코리아 (제조국 : 아랍에미리트)', '초콜릿', '킷캣 오리지널 18입, 네슬레코리아 (제조국 : 아랍에미리트)', '0', '킷캣 오리지널 18입', '9980', '4.9', 'https://sitem.ssgcdn.com/21/16/61/item/1000529611621_i1_1100.jpg');
INSERT INTO `emart`.`product` (`id`, `brand`, `category`, `description`, `discount`, `name`, `price`, `rating`, `thumbnail`) VALUES ('3', 'HERSHEY CANADA INC (제조국 : 캐나다)', '초콜릿', '허쉬 다크초콜릿 아사이&블루베리210g, 초콜릿가공품', '0', '허쉬 다크초콜릿 아사이&블루베리210g', '9080', '4.8', 'https://sitem.ssgcdn.com/90/11/54/item/1000270541190_i1_1100.jpg');
INSERT INTO `emart`.`product` (`id`, `brand`, `category`, `description`, `discount`, `name`, `price`, `rating`, `thumbnail`) VALUES ('4', '(주)농심', '초콜릿', 'LINDT&SPRUNGLI SAS / (주)농심 / 서울특별시 동작구 여의대방로112(신대방동) (제조국 : 상세설명참조)', '0', '[린트]엑설런스 다크 99% 50g', '6860', '4.8', 'https://sitem.ssgcdn.com/50/75/43/item/1000029437550_i1_1100.jpg');
INSERT INTO `emart`.`product` (`id`, `brand`, `category`, `description`, `discount`, `name`, `price`, `rating`, `thumbnail`) VALUES ('5', '(주)농심', '라면', '한국인의 입맞에 맞는 매운 라면', '100', '[농심]신라면', '1000', '2.8', 'http://image.nongshim.com/non/pro/1647822522999.jpg');
INSERT INTO `emart`.`product` (`id`, `brand`, `category`, `description`, `discount`, `name`, `price`, `rating`, `thumbnail`) VALUES ('6', '롯데칠성음료', '스포츠 음료', '세계 1위 스포츠 음료 게토레이', '500', '게토레이 레몬맛 1.5L', '2100', '3.4', 'https://maks.co.kr/web/product/tiny/202211/84c569091f47a287cf95dc937230d3d3.jpg');
INSERT INTO `emart`.`product` (`id`, `brand`, `category`, `description`, `discount`, `name`, `price`, `rating`, `thumbnail`) VALUES ('7', '크라운', '과자(스낵)', '달콤한 초콜릿 과자', '300', '쵸코하임', '6860', '4.8', 'http://www.crown.co.kr/upload/item/%EC%B5%B8%EC%BD%94%ED%95%98%EC%9E%84.jpg');
INSERT INTO `emart`.`product` (`id`, `brand`, `category`, `description`, `discount`, `name`, `price`, `rating`, `thumbnail`) VALUES ('8', '페레로 아시아 리미티드 한국지점', '초콜릿(과자류)', '이탈리아 정통 프리미엄 초콜릿! 사랑을 담아 사랑하는 사람에게 선물하기 좋은 이탈리아 정통 프리미엄 초콜릿 페레로 로쉐입니다.', '1000', '페레로로쉐 T8 하트 100g', '8400', '3.8', 'https://sitem.ssgcdn.com/31/12/61/item/0000006611231_i1_1100.jpg');
INSERT INTO `emart`.`product` (`id`, `brand`, `category`, `description`, `discount`, `name`, `price`, `rating`, `thumbnail`) VALUES ('9', '델몬트', '음료(주스)', '싱그러운 오렌지 펄프가 톡톡', '600', '콜드 오렌지 주스 1L', '3500', '3.6', 'https://m.mrjt.kr/web/upload/NNEditor/20211028/mobile/42cfbf6c813319e8b0a9babc7f36b060_1635384704.jpg');
INSERT INTO `emart`.`product` (`id`, `brand`, `category`, `description`, `discount`, `name`, `price`, `rating`, `thumbnail`) VALUES ('10', '삼양', '과자', '국내산 아카시아 꿀의 고소한 맛 ', '400', '삼양 짱구 115g', '2000', '3.1', 'http://image.auction.co.kr/itemimage/11/57/34/1157346976.jpg');


INSERT INTO `emart`.`cart` (`id`, `qty`, `product_id`, `user_id`) VALUES ('1', '3', '2', '1');
INSERT INTO `emart`.`cart` (`id`, `qty`, `product_id`, `user_id`) VALUES ('2', '3', '3', '1');

INSERT INTO `emart`.`event` (`id`, `name`, `start_date`,`end_date`) VALUES ('1', '식목일 행사', '2023-04-01', '2023-04-05');
INSERT INTO `emart`.`event` (`id`, `name`, `start_date`,`end_date`) VALUES ('2', '부산 이벤트', '2023-03-01', '2023-03-31');
INSERT INTO `emart`.`event` (`id`, `name`, `start_date`,`end_date`) VALUES ('3', '봄날 이벤트', '2023-05-18', '2023-05-31');
INSERT INTO `emart`.`event` (`id`, `name`, `start_date`,`end_date`) VALUES ('4', '음료 할인행사', '2023-04-10', '2023-04-15');

INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('1', '2', '2');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('2', '3', '1');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('3', '2', '7');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('12', '1', '8');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('4', '3', '3');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('5', '1', '7');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('6', '3', '4');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('7', '1', '10');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('8', '2', '8');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('9', '2', '5');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('10', '4', '6');
INSERT INTO `emart`.`event_product` (`id`, `event_id`, `product_id`) VALUES ('11', '4', '9');
