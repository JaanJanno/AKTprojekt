SimplASM
==========
Koostajad: Jaan Janno, Tõnis Kasekamp, Juhan-Rasmus Risti

SimplASM on projekt, mis hõlmab endas assemblerkeelt ja virtuaalmasinat, mille peal saab jooksutada selles keeles loodud programme. Projekti eesmärgiks on tutvustada assemblerkeele tööpõhimõtet ja protseduure selle huvilistele.

#### Käivitamine

Programmi main meetod asub klassis main.Intro

#### Toetatud väärtused

**123** - arvuliteraal.

**[123]** - pointer, kus kantsulgude sees olev arvuliteraal määrab mälupesa, milles olevale väärtusele viidatakse.

**A B C X Y Z** - kuus erinevat registrit.

**[A] [B] [C] [X] [Y] [Z]** - kuus registrit on kasutatavad ka pointeritena, kus registri sisu viitab mälupesale.

**[A + arvuliteraal] .. [Z + arvuliteraal]** - kuus registrit on kasutatavad pointeritena ka sellisel viisil, kus registri sisu ja arvuliteraali summa viitab mälupesale.

**SP** - stack pointer. Eriline register, mis näitab, kui kõrge magasin parasjagu on.

**PC** - program counter. Eriline register, mis näitab, kui kaugel mälus programmi täitmine parasjagu on.

**POP** - Tagastab magasini pealmise väärtuse. Põhjustab ka stack pointer'i väärtuse ühe võrra kasvamise.

**PEEK** - Tagastab magasini pealmise väärtuse ilma stack pointer'it muutmata.

#### Toetatud käsustik

**MOV a, b** - kopeerib väärtuse b väärtusesse a.

**DAT a, b .. n** - lisab toorelt mälusse argumendiks antud väärtused. Võib lisada kuitahes palju argumente.

##### Aritmeetilised tehted

**ADD a, b** - liidab väärtusele a väärtuse b.

**SUB a, b** - lahutab väärtusest a väärtuse b.

**MUL a, b** - korrutab väärtuse a väärtusega b.

**DIV a, b** - jagab väärtuse a väärtusega b.

**MOD a, b** - omistab väärtusele a jäägi jagatisest a / b.

##### Tehted magasiniga

**EPOP** - tõstab stack pointerit ühe võrra.

**PUSH a** - lahutab stack pointerist ühe ja lisab stack pointeri poolt viidatavale mälupesale väärtuse a.

##### Loogikatehted

**AND a, b** - väärtusesse a omistatakse a ja b bitwise and tehte tulemus.

**OR a, b** - väärtusesse a omistatakse a ja b bitwise or tehte tulemus.

**XOR a, b** - väärtusesse a omistatakse a ja b bitwise xor tehte tulemus.

**NOT a** - väärtuseks a omistatakse tema bitwise not tehte tulemus.

##### _Branching_

**IFE a, b** - kui väärtused a ja b on võrdsed, siis täidetakse järgmine käsk, muul juhul hüpatakse järgmisest käsust üle.

**IFN a, b** - kui väärtused a ja b ei ole võrdsed, siis täidetakse järgmine käsk, muul juhul hüpatakse järgmisest käsust üle.

**IFG a, b** - kui väärtus a on suurem b-st, siis täidetakse järgmine käsk, muul juhul hüpatakse järgmisest käsust üle.

**IFL a, b** - kui väärtus a on väiksem b-st, siis täidetakse järgmine käsk, muul juhul hüpatakse järgmisest käsust üle.

**IFGE a, b** - kui väärtus a on võrdne või suurem b-st, siis täidetakse järgmine käsk, muul juhul hüpatakse järgmisest käsust üle.

**IFLE a, b** - kui väärtus a on võrdne või väiksem b-st, siis täidetakse järgmine käsk, muul juhul hüpatakse järgmisest käsust üle.

##### _Bitshift_'id

**SHL a, b** - väärtuse a bitid lükatakse väärtuse b võrra vasakule.

**SHR a, b** - väärtuse a bitid lükatakse väärtuse b võrra paremale.

##### Riistvarakäsud

**SD** - shut down. Lõpetab protsessori töö.

##### _Label_'id

<i>Nb, labelid eksisteerivad ainult assemblerkeeles. Kompileerimise ajal asendatakse kõik labelid arvudega ning cpu ei tea labelite kohta midagi.</i>

**\_mingistring\_** - label'i deklaratsioon. Selle nime alt saab hiljem kätte labelile järgneva käsu mälupesa aadressi.

**:mingistring:** - label'i kasutamine väärtusena. Kasutab deklareeritud labeli mälupesa aadressi väärtusena. Näiteks MOV PC, :label: liigutab program counteri labeli label all oleva käsu juurde.
