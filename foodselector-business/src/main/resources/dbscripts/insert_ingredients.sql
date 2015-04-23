/** meat origin */
insert into MEAT_ORIGIN(name, info, meat_type) values('VARKEN', 'TODO', 'RED');
insert into MEAT_ORIGIN(name, info, meat_type) values('KIP', 'TODO', 'WHITE');
insert into MEAT_ORIGIN(name, info, meat_type) values('RUND', 'TODO', 'RED');
insert into MEAT_ORIGIN(name, info, meat_type) values('KALF', 'TODO', 'RED');
insert into MEAT_ORIGIN(name, info, meat_type) values('LAM', 'TODO', 'RED');
insert into MEAT_ORIGIN(name, info, meat_type) values('GEVOGELTE', 'TODO', 'WHITE');
insert into MEAT_ORIGIN(name, info, meat_type) values('PAARD', 'TODO', 'RED');
insert into MEAT_ORIGIN(name, info, meat_type) values('SCHAAP', 'TODO', 'RED');

/** meat*/
insert into MEAT(name, info) values ('Kippenworst','TODO');
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(2,1);
insert into MEAT(name, info) values ('Spek','TODO');
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(1,2);
insert into MEAT(name, info) values ('Runds/Varkens Gehakt','TODO');
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(1,3);
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(3,3);
insert into MEAT(name, info) values ('Rundsteak','TODO');
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(3,4);
insert into MEAT(name, info) values ('Kotelet','TODO');
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(1,5);
insert into MEAT(name, info) values ('Kipfilet','TODO');
insert into MEAT_MEATORIGINS(MEAT_ORIGIN_ID, MEAT_ID) values(2,6);

/** fish origin */
insert into FISH_ORIGIN(name, info, fish_type) values('TONIJN', 'Todo', 'HALF_OILY');
insert into FISH_ORIGIN(name, info, fish_type) values('ZALM', 'Todo', 'OILY');
insert into FISH_ORIGIN(name, info, fish_type) values('MOSSELEN', 'Todo', 'SEAFOOD');
insert into FISH_ORIGIN(name, info, fish_type) values('HARING', 'Todo', 'OILY');
insert into FISH_ORIGIN(name, info, fish_type) values('KABELJAUW', 'Todo', 'WHITE');

/** fish */
insert into FISH(name, info, fish_fishOrigin_id) values('fishstick', 'TODO', 5);
insert into FISH(name, info, fish_fishOrigin_id) values('kabeljauwfilet', 'TODO', 5);
insert into FISH(name, info, fish_fishOrigin_id) values('gerookte zalm', 'TODO', 2);
insert into FISH(name, info, fish_fishOrigin_id) values('rolmops', 'TODO', 4);

/** vegetable family */
insert into VEGETABLES_FAMILY(name, info) values('BLADGROENTEN', 'Bladgroenten komen van planten met goed ontwikkelde bladeren. Het zijn die bladeren die worden opgegeten. Ze bevatten veel vitaminen en mineralen en worden zowel gekookt als rauw gegeten.');
insert into VEGETABLES_FAMILY(name, info) values('KOOLSOORTEN',' Koolsoorten bevatten veel vezels, vitamine A en C. Bovendien zijn ze calorie-arm. Er is binnen deze familie veel variatie mogelijk.');
insert into VEGETABLES_FAMILY(name, info) values('PEULVRUCHTEN','Eens gekookt, zitten er veel voedingsstoffen in bonen: eiwitten, vitamine A en C, calcium en fosfor');

/** vegetables */
insert into VEGETABLES (name, info, vegetables_vf_id) values('Witloof','Klaarmaken met bruine suiker', 1);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Spinazie','TODO', 1);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Bloemkool','', 2);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Bonen','', 3);

