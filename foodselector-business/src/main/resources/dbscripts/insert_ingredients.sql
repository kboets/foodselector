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
insert into VEGETABLES_FAMILY(name, info) values('PEULVRUCHTEN','Peulvruchten zijn echter ook heel gezond. Ze zijn rijk aan koolhydraten, eiwitten, B- vitamines en mineralen, zoals ijzer, calcium, molybdeen en fosfor. Ze zijn vezelrijk en caloriearm wat inhoud dat je door het eten van peulvruchten wel een verzadigd, vol gevoel krijgt, maar niet veel calorieën tot je neemt');
insert into VEGETABLES_FAMILY(name, info) values('WORTEL- EN KNOLGEWASSEN','Wortel- en knolgewassen zijn de delen van een plant waarvan de wortel is uitgegroeid tot een eetbare groente');
insert into VEGETABLES_FAMILY(name, info) values('STENGELGROENTEN','Stengelgroenten zijn de uitlopers van de wortel van een plant, namelijk de delen die boven de grond uitgroeien. Het gaat bij deze groep vooral om de vlezige bladstelen');

/** vegetables */
insert into VEGETABLES (name, info, vegetables_vf_id) values('Witloof','Klaarmaken met bruine suiker', 1);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Spinazie','TODO', 1);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Bloemkool','Bloemkoolroosjes worden rauw gegeten als aperitiefhapje of in slaatjes. Op dat moment zit er veel vitamine C in. Maar ook gekookt, gestoomd, gestoofd of gebakken gegeten worden', 2);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Brocoli','Net zoals bij bloemkool worden de roosjes of knoppen gegeten.  Broccoli bevat veel vitamine C, zowel in de groene als in de paarse versie', 2);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Spruiten','Eigenlijk zijn spruitjes heel kleine kooltjes, dat merkt u ook als u ze doormidden snijdt. Ze zitten boordevol vitamine C.', 2);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Sperzie bonen','', 3);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Snijbonen','', 3);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Erwten','', 3);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Wortelen','Het positieve hieraan is dat deze groente heel wat caroteen bevat, een stof die in het lichaam in vitamine A wordt omgezet en die goed is voor huid en ogen.Wortelen kunnen ook op verschillende manieren klaargemaakt worden; gekookt, gestoofd, gestoomd... Zelfs rauw zijn ze heel fris en smakelijk', 4);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Schorseneren','', 4);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Asperges','Asperges zijn een bijzonder voedzame groente. Er zit een groot aantal verschillende vitaminen in. ', 5);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Ajuin','Uien zitten vol met vitamine C. Verder zit er redelijk wat B6 en B11 in. ', 5);
insert into VEGETABLES (name, info, vegetables_vf_id) values('Prei','Het vermindert cholesterol en belemmert schadelijke enzymen in de lever. Bovendien verschaft het 52% ADH vitamine K en meer dan 29% ADH vitamine A. Dan bevat prei ook nog foliumzuur, niacine, riboflavine, magnesium en thiamine.', 5);