/* 1)How many homes with a garage were listed for sale this year in each city? Only show cities with more than 5 homes in the result. */ 
select city, count(*)
from RES.vlist
where GARAGE = 'Y'
group by city
having count(*) > 5;

DORVAL	179
BEACONSFIELD	337
LONGUEUIL	25
POINTE-CLAIRE	322
MONTREAL	245
DDO	498
LASALLE	88
BROSSARD	63
WESTMOUNT	169
NDG	96

/*2.	Which home is the most expensive home for sale in Montreal with a fireplace and a price lower than the average price of a home for sale in Westmount that is not a condo or a semid? */
select *
from res.vlist
WHERE city = 'MONTREAL' and (lower(detail) like '%fireplace%' or lower(detail) like '%fireplaces%')
and price < (select AVG(price) from res.vlist where type not in ('CONDO','SEMID') and city = 'WESTMOUNT')
order by price desc;

718	435 Simcoe		MONTREAL	769000	COTTG		4	2.5		Fireplace	05-03-14	CS714

/* 3.	Which houses for sale have a pool, a hot tub, or a jacuzzi, and are on the Lakeshore, waterfront, or have a water view, and are priced over 650,000? List in order of price within city.  */

select * 
from RES.vlist
where (lower(addr) like '%lakeshore%' or lower(detail) like '%waterfront%' or (lower(detail) like '%water%' and lower(detail) like '%view%'))
and (lower(detail) like '%jacuzzi%' or lower(detail) like '%hot tub%' or pool = 'Y')
and price > 650000
order by city, price;

33507	589 Lakeshore Rd.	null	EACONSFIELD	699000	COTTG	Y	4	3		Lake View	10-01-18	CS335
31808	1086 Bellevue			BEACONSFIELD	1575000	COTTG	Y	5	6.5	Y	Waterfront, fireplace	99-07-04	CS318
20708	4555 Beaconsfield Bd	BEACONSFIELD	1695000	SPLIT	Y	5	2.5	Y	Waterfront, Triple garage	00-02-03	CS207
27603	6218 Lakeshore			BEACONSFIELD	3782000	COTTG	Y	7	5.5	Y	Big and roomy	02-03-13	CS276
21100	24 Albert Lacombe			DDO	1375000	COTTG	Y	5	3.5	Y	WATERFRONT	00-01-11	CS211
71909	850 Bord Du Lac Lakeshore		DORVAL	875000	CONDO	Y	2	2	Y	Water view	05-03-14	CS719
56600	2385 Chemin Bord du Lac		DORVAL	890000	BUNGL	Y	5	4	Y	Waterview	10-03-15	CS566
12724	40 Tsse Whitehead			DORVAL	2495000	BUNGL	Y	6	5	Y	Waterfront	15-01-23	CS127
11913	1830 Ch. du BdLLakeshore	DORVAL	4200000	COTTG	Y	6	5	Y	Waterfront	15-01-23	CS119
53602	54 Lakeshore				MONTREAL	1199000	SEMID	Y	4	3	Y	Bright and Spacious	08-03-10	CS536
34903	2380 Dupuy	PH1A			MONTREAL	1575000	CONDO	Y	1	1	Y	Waterfront	09-03-11	CS349
53905	54 Lakeshore Rd				MONTREAL	1999000	BUNGL	Y	4	1	Y	Lake View	10-03-06	CS539
53611	13495 Huntington			NDG	2200000	BUNGL	Y	6	4	Y	Stunning waterfront property	08-03-10	CS536
34300	148 Lakeshore				POINTE-CLAIRE	1495000	COTTG	Y	3	2	Y	AC, pool	09-03-11	CS343
63501	400 Lakeshore Road			POINTE-CLAIRE	1975000	COTTG	Y	5	3	Y	lake view	12-03-01	CS635
64808	4 Stewart					POINTE-CLAIRE	3689000	COTTG	Y	6	5	Y	Waterfront property	12-03-01	CS648

/*  4.	List the names of silver level agents hired in 2014 or 2015, along with the number of homes they have sold. Include the agents who did not sell any homes. */ 

select a.agnum, a.AGFIRST, a.AGLAST, a.AGHIRED, a.AGLEVEL, count(z.mlsno)
from RES.agent a left join res.vsold z on a.agnum = z.lagnt
where a.AGLEVEL = 'S' and to_char(aghired, 'yyyy') in (2014,2015) 
group by a.agnum, a.AGFIRST, a.AGLAST, a.AGHIRED, a.AGLEVEL;

CS672	Daniel	Stellema	14-03-11	S	2
CS141	Patrick	Nadeau	    14-12-31	S	0
CS116	Alex	Fourneaux	15-01-19	S	1

/* 5.	Which agent has listed the highest priced cottage this year? Show the name of the agent. */ 

select agfirst, aglast
from res.agent a join res.vlist z on a.agnum = z.lagnt
where price = (select max(price) from res.vlist where type = 'COTTG' and to_char(ldate, 'yyyy') in (2015));

Simon	Levasseur

/* 6.	List the full name, phone number and the day of the week that they were hired, for agents with the first name Eric. All agents named Eric, no matter of how they spell Eric, should be included in the list. (Hint: look up the soundex function) */

select aglast, agfirst, to_char(aghired, 'DAY') as "day of week hired", agphone
from res.agent
where SOUNDEX(agfirst) = SOUNDEX('Eric');

Venditti	Eric	FRIDAY   	624-0000
Volpato		Eric	WEDNESDAY	555-5555
Wand		Eric	FRIDAY   	620-2110
Frappier	Eric	MONDAY   	457-0585
Parent		Eric	FRIDAY   	263-4174
Fontaine	Eric	THURSDAY 	455-2334
Zaidi		Eric	TUESDAY  	453-8797
Rideough	Eric	MONDAY   	555-0718
Chan		Eric	SUNDAY   	211-0690
Gagnon		Eric	THURSDAY 	5550143 
Ray			Erik	THURSDAY 	555-1359
GILES		Eric	THURSDAY 	555-4287
Smith		Erik	TUESDAY  	522-5555
Davies		Eric	SUNDAY   	555-5555
Bottazzi	Eric	TUESDAY  	343-0343
Frenza		Eric	TUESDAY  	694-5555

/* 7. What is the most popular type of home that is sold? */
select type, count(type)
from res.vsold
group by type
having count(type) = (select max(count(type)) from res.vsold group by type);

COTTG	209

/* 8. Which homes are the five most expensive homes for sale? Include the agent name and phone number. **/
select AGFIRST, AGLAST, agphone, mlsno, addr, city
from (select a.*, b.AGFIRST, b.AGLAST, b.AGPHONE from res.vlist a join res.agent b on a.lagnt = b.agnum order by price desc)
where rownum <= 8;
/* These both work */
select AGFIRST, AGLAST, agphone, mlsno, addr, city, rank() over(order by price desc) as "rank",price
from res.vlist join res.agent on lagnt=agnum
order by price desc;


Kevin		Ve		420-8008	12721	3090 Rue Jean-Girard	MONTREAL	8900000
Daric		Martin	457-6610	12145	4333 Av. Westmount	WESTMOUNT	7600000
Benjamin	Barault	455-6618	67402	1903 Bord-du-Lac	MONTREAL	6000000
Benjamin	Barault	455-6618	67403	68 Summit Circle	MONTREAL	5750000
Donald		McPhee	555-5555	68605	3657 Boul. The Boulevard	WESTMOUNT	5500000
Donald		Kapran	241-0774	20009	19 Forden	WESTMOUNT	5500000

/* 9. Show the average price for each type of home in 2005, followed by the average price of each type of home in 2015. List in order of type and then year. */
select type,to_char(ldate, 'YYYY') as "year", round(avg(price),0)
from res.vlist 
where to_char(ldate, 'YYYY') = 2005 or to_char(ldate, 'YYYY') = 2015
group by type, to_char(ldate, 'YYYY')
order by type, to_char(ldate, 'YYYY');

BUNGL	2005	287134
BUNGL	2015	584524
CONDO	2005	357704
CONDO	2015	399105
COTTG	2005	534854
COTTG	2015	894422
SEMID	2005	305208
SEMID	2015	1326595
SPLIT	2005	391479
SPLIT	2015	602067

/* 10. Which house is the most expensive in each of these cities (Westmount, DDO, Dorval)? (Include mlsno, address, type, listing price and agent's name in answer). */
select  price,mlsno,addr, type, city
from res.vlist x
where city in ('WESTMOUNT', 'DDO', 'DORVAL') and x.price = (select max(price) from res.vlist b where x.city=b.city);

2490000	55809	167 Rue Montevista	COTTG	DDO
4200000	11913	1830 Ch. du BdLLakeshore	COTTG	DORVAL
7600000	12145	4333 Av. Westmount	SEMID	WESTMOUNT

/* 11. List the last name, agent's level and month hired (ex. January) of all agents who have sold a home in the last 30 days. For the agent's level, show the name of the level not just the code (check the decode function). Show: Gold, Silver, Novice, or Millionaire instead of G, S, N, or M. */
select to_char(aghired, 'month'), 
      decode (aglevel, 'G', 'Gold',
                       'S', 'Silver',
                       'N', 'Novice',
                       'M', 'Millionaire')
from res.vsold join res.agent on lagnt = agnum
where sdate > sysdate-30 and sdate < sysdate;
october  	McIntyre	Novice
october  	McIntyre	Novice
february 	Carrier		Silver
january  	Fourneaux	Silver
july     	Duskes		Millionaire
october  	Shapiro		Millionaire
october  	Beliveau	Millionaire
october  	Beliveau	Millionaire
january  	Laframboise	Millionaire
may      	Irshad		Gold
december 	Ve			Millionaire
october  	Levasseur	Millionaire
november 	McCarthy	Gold
may      	Magnan		Millionaire
may      	Burns		Gold
january  	David		Novice
september	Deschamps	Gold
january  	Lazarek		Gold
september	Wang		Silver
december 	Rizk		Silver

/* 12. The real estate agent SCOTT (lagnt is CS300) has some homes listed (but no view vlist) but the listings did not get into the RES tables.  A buyer is looking for a home in Beaconsfield with a price of 359000. Check both RES and SCOTT to list all of the homes for sale at that price in that city. Show mlsno, addr, detail, type, city, lagnt in order by type.  */
select mlsno, addr, detail, type, city, lagnt, price
from scott.homes
where city = 'BEACONSFIELD' and price = 359000;
union
select mlsno, addr, detail, type, city, lagnt, price
from res.vlist
where city = 'BEACONSFIELD' and price = 359000;

30019	162 Rue Beaurepaire	Renovated	BUNGL	BEACONSFIELD	CS300	359000
30022	222 Sherwood	Quiet.Recently renovated	SPLIT	BEACONSFIELD	CS300	359000
