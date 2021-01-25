INSERT INTO tb_gambler (email) VALUES ('alex@example.com');
INSERT INTO tb_gambler (email) VALUES ('nelio@example.com');
INSERT INTO tb_gambler (email) VALUES ('maria@example.com');
INSERT INTO tb_gambler (email) VALUES ('jessica@example.com');

INSERT INTO tb_bet (numbers, created_At, type_Draw, status ) VALUES ('aced0005757200025b494dba602676eab2a5020000787000000006000000390000000f0000000d0000000e0000001b0000000c', NOW(), 6, 0);
INSERT INTO tb_bet (numbers, created_At, type_Draw, status ) VALUES ('aced0005757200025b494dba602676eab2a5020000787000000006000000390000003b0000003c000000180000001b0000001a', NOW(), 6, 0);
INSERT INTO tb_bet (numbers, created_At, type_Draw, status ) VALUES ('aced0005757200025b494dba602676eab2a50200007870000000060000000f000000140000002c000000130000001700000033', NOW(), 6, 0);
INSERT INTO tb_bet (numbers, created_At, type_Draw, status ) VALUES ('aced0005757200025b494dba602676eab2a5020000787000000006000000100000002c0000003300000007000000270000001a', NOW(), 6, 0);
INSERT INTO tb_bet (numbers, created_At, type_Draw, status ) VALUES ('aced0005757200025b494dba602676eab2a50200007870000000060000002f0000001700000005000000370000001a00000030', NOW(), 6, 0);

INSERT INTO tb_gambler_bet (gambler_id, bet_id) VALUES (1 , 1);
INSERT INTO tb_gambler_bet (gambler_id, bet_id) VALUES (1 , 2);
INSERT INTO tb_gambler_bet (gambler_id, bet_id) VALUES (2 , 3);
INSERT INTO tb_gambler_bet (gambler_id, bet_id) VALUES (3 , 4);
INSERT INTO tb_gambler_bet (gambler_id, bet_id) VALUES (4 , 5);
