package pt.ipbeja.estig.twdm.pdm1.project.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import pt.ipbeja.estig.twdm.pdm1.project.models.Book;
import pt.ipbeja.estig.twdm.pdm1.project.models.User;

@Database(entities = {Book.class, User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract BookDao getBookDao();
    public abstract UserDao getUserDao();

    private static AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class,
                    "myAppDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Cara Senhora Tosoni Os postais da Casabella', " +
                                    "'Este é um livro carregado de ironia, erudição, imagens e violência. Violência da construção, imagens de arquitectura, erudição e ironia do autor que, entre 1982 e 1995, enviou regularmente postais à Senhora Tosoni, a secretária da redacção da revista milanesa Casabella, então dirigida por Vittorio Gregotti.\n" + "\n" + "Os postais foram, ao longo do século XX, uma forma maior da iconografia epistolar. Produzidos industrialmente, em circulação pelo mundo, os postais transportam imagens com indícios de comportamentos sociais e práticas de construção.\n" + "\n" + "Jacques Gubler escalpeliza estas imagens em missivas sintéticas, por vezes herméticas, que reverberam nexos escondidos pelo hábito celebrativo que tantas vezes se confere à história.\n" + "\n" + "A arquitectura, o design industrial, a história do movimento moderno, os autores e os veículos da arte, da pintura, da literatura e do conhecimento são convocados numa interrogação constante ao sentido das imagens do mundo.', " +
                                    "'https://almedinanet.b-cdn.net/media/catalog/product/cache/10f519365b01716ddb90abc57de5a837/9/7/9789898217530_1614333762.jpg'," +
                                    " 'Artes', " +
                                    "'Jacques Gubler', " +
                                    "'2002', " +
                                    "3, '1', '0')");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Espectros do Cinema', " +
                                    "'Este livro é uma galeria de retratos de figuras que, como se diz em Benilde, «não são deste mundo», figuras fantasmáticas, prometidas a uma existência liminar, que adquirem uma espécie de inteireza justamente na sua inconsistência ôntica.\n" + "\n" + "A figura do fantasma tem acompanhado a história do cinema desde o século XIX até aos nossos dias, marcando presença numa grande diversidade de géneros fílmicos. Além disso, a própria arte cinematográfica tem sido, repetidas vezes, considerada e descrita como uma coisa espectral em si mesma.\n" + "\n" + "Em 1896, Máximo Gorki qualificou o cinema como um reino de sombras, e, já no século XXI, Jacques Derrida afirmou que a experiência cinematográfica pertence à esfera da espectralidade. Deste modo, ir ao cinema implica necessariamente confraternizar com espectros, ser assombrado, quer os filmes tornem os fantasmas visíveis, quer não.\n" + "\n" + "No contexto português, Manoel de Oliveira e João Pedro Rodrigues surgem como os cineastas que reflectiram sobre a espectralidade do cinema de forma mais consistente. Atentando no funcionamento das suas narrativas de amor, loucura e morte, bem como nos seres que as protagonizam, votados a uma existência liminar, entre o mundo dos mortos e o dos vivos, este livro constrói uma galeria de retratos de figuras fantasmáticas, que, como se diz em Benilde ou a Virgem Mãe, «não pertencem a este mundo».', " +
                                    "'https://img.wook.pt/images/espectros-do-cinema-jose-bertolo/MXwyNDU5MTQyMnwyMDcxMTA5MXwxNjEyMTM3NjAwMDAwfHdlYnA=/502x', " +
                                    "'Artes', " +
                                    "'José Bértolo', " +
                                    "'2005', " +
                                    "2, '0', '1')");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Obras-Primas da Arte Portuguesa', " +
                                    "'A colecção OBRAS-PRIMAS DA ARTE PORTUGUESA, procurando dar a conhecer o nosso património artístico mais relevante - Arquitectura, Pintura, Escultura, Ourivesaria e Artes Visuais no Século XX - , destina-se ao grande público . Em cinco volumes amplamente ilustrados, reputados especialistas em História da Arte Portuguesa, nas diversas especialidades, dão-nos a conhecer, através de abordagens originais, acessíveis e com garantido rigor científico, 50 obras-primas que seleccionaram entre tesouros nacionais e as mais notáveis criações contemporâneas. Século XX. Artes Visuais - do auto-retrato de Aurélia de Sousa, de 1900, a João Onofre, através de uma obra de 2000, Delfim Sardo apresenta-nos as obras mais relevantes que neste século se realizaram em Portugal.', " +
                                    "'https://img.wook.pt/images/obras-primas-da-arte-portuguesa-delfim-sardo/MXwxMDk5Njc3MXw2NTY3NDYxfDEzODM1MjMyMDAwMDA=/500x', " +
                                    "'Artes', " +
                                    "'Delfim Sardo', " +
                                    "'2000', " +
                                    "2, '1', '0')");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Almoço de Domingo', " +
                                    "'Um romance, uma biografia, uma leitura de Portugal e das várias gerações portuguesas entre 1931 e 2021. Tudo olhado a partir de uma geografia e de uma família.\n" +
                                    "\n" +
                                    "Com este novo romance de José Luís Peixoto acompanhamos, entre 1931 e 2021, a biografia de um homem famoso que o leitor há de identificar — em paralelo com história do país durante esses anos. No Alentejo da raia, o contrabando é a resistência perante a pobreza, tal como é a metáfora das múltiplas e imprecisas fronteiras que rodeiam a existência e a literatura. Através dessa entrada, chega-se muito longe, sem nunca esquecer as origens. Num percurso de várias gerações, tocado pela Guerra Civil de Espanha, pelo 25 de abril, por figuras como Marcelo Caetano ou Mário Soares e Felipe González, este é também um romance sobre a idade, sobre a vida contra a morte, sobre o amor profundo e ancestral de uma família reunida, em torno do patriarca, no seu almoço de domingo.', " +
                                    "'https://img.wook.pt/images/almoco-de-domingo-jose-luis-peixoto/MXwyMTMzMjE5OHwxNzIxODM0MnwxNjE0ODE2MDAwMDAwfHdlYnA=/502x', " +
                                    "'Romance', " +
                                    "'José Luís Peixoto', " +
                                    "'2021', " +
                                    "2, '0', '0')");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Durante a Queda Aprendi a Voar', " +
                                    "'Quando Teresa recebe a notícia de que o pai tem uma depressão, está longe de imaginar que os próximos tempos serão os mais intensos e transformadores da sua vida. Determinada em ajudar o pai, Teresa começa a acompanhá-lo nas terapias de grupo numa clínica de saúde mental.\n" +
                                    "\n" +
                                    "É aqui que conhece Duarte, o irmão de um paciente internado na clínica, cujo passado permanece envolto em mistério. Ela é resoluta e pragmática, ele romântico e brincalhão, mas, apesar das diferenças, o destino insiste em tentar juntá-los. Tudo se complica quando Teresa começa a ter inexplicáveis pressentimentos e visões. Será que ela é capaz de prever o futuro? E será que Duarte faz parte dele?\n" +
                                    "\n" +
                                    "Raul Minh’alma é o mais recente fenómeno literário nacional. O autor do livro mais vendido em Portugal no ano de 2019 está de regresso com mais uma história de amor e superação pessoal que promete dar-te ensinamentos essenciais para venceres as fases negativas da tua vida.\n" +
                                    "PORQUE MESMO QUE DOA PRECISAMOS DE SEGUIR EM FRENTE', " +
                                    "'https://img.wook.pt/images/durante-a-queda-aprendi-a-voar-raul-minhalma/MXwyNDQxODk2MHwyMDUxMDE1N3wxNjAzMTQ4NDAwMDAwfHdlYnA=/502x', " +
                                    "'Romance', " +
                                    "'Raul Minh alma', " +
                                    "'2020', " +
                                    "2, '0', '0')");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Antes que o Café Arrefeça', " +
                                    "'O que faria se pudesse voltar atrás no tempo?\n" +
                                    "Um romance tocante e inspirador.\n" +
                                    "\n" +
                                    "Um rumor circula por Tóquio. Escondido num pequeno beco da cidade, dentro de uma cave, há um café com mais de cem anos. Com uma chávena bem quente, se nos sentarmos no lugar certo, oferecem-nos algo mais: a hipótese de voltar ao passado. Em Antes Que o Café Arrefeça, acompanhamos as viagens de quatro mulheres que procuram regressar a momentos determinantes das suas vidas para os mudar: falar com o namorado que partiu, ler a carta do marido com Alzheimer, ver a irmã pela última vez e conhecer a filha que nunca viu. Mas as viagens no tempo têm condições e riscos… e nada do que façam vai alterar o presente.\n" +
                                    "\n" +
                                    "Uma mesa, um café e uma decisão.\n" +
                                    "Uma história sobre o amor, o tempo perdido e as oportunidades que o futuro nos reserva.', " +
                                    "'https://img.wook.pt/images/antes-que-o-cafe-arrefeca-toshikazu-kawaguchi/MXwyNDcwNDU3N3wyMDg1NjkyMHwxNjE3MTQ1MjAwMDAwfHdlYnA=/502x', " +
                                    "'Romance', " +
                                    "'Toshikazu Kawaguchi', " +
                                    "'2021', " +
                                    "2, '0', '0')");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Os Maias', " +
                                    "'Os Maias encerra uma crónica de costumes, retratando, com rigor fotográfico e muito humor, a sociedade lisboeta da segunda metade do século XIX.\n" +
                                    "\n" +
                                    "Trata-se da obra-prima de Eça de Queirós, publicada em 1888, e uma das mais importantes de toda a literatura portuguesa.\n" +
                                    "\n" +
                                    "Vale principalmente pela linguagem em que está escrita e pela fina ironia com que o autor define os caracteres e apresenta as situações. É um romance realista (e naturalista), onde não faltam o fatalismo, a análise social, as peripécias e a catástrofe próprios do enredo passional.\n" +
                                    "\n" +
                                    "A obra ocupa-se da história de uma família (Maia) ao longo de três gerações, centrando-se depois na última geração e dando relevo aos amores incestuosos de Carlos da Maia e Maria Eduarda.\n" +
                                    "\n" +
                                    "Mas a história é também um pretexto para o autor fazer uma crítica à situação decadente do país (a nível político e cultural) e à alta burguesia lisboeta oitocentista, por onde perpassa um humor (ora fino, ora satírico) que configura a derrota e o desengano de todas as personagens.', " +
                                    "'https://img.wook.pt/images/os-maias-eca-de-queiros/MXwyOTE5MDU5fDIwODQ5MzY2fDE2MTcxNDUyMDAwMDB8d2VicA==/502x', " +
                                    "'Romance', " +
                                    "'Eça de Queirós', " +
                                    "'2021', " +
                                    "10, '0', '0')");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Fiona & Lucifera', " +
                                    "'Olá, eu sou a Fiona, a “mãe adotiva” de dois felinos, a Lucy e o Fera, que me deixam viver lá em casa se não incomodar muito. A Lucy é uma gata de três quilos e ternura que nunca mais acaba. O Fera é um gato branco, obcecado por comida e com muito mau-feitio.\n" +
                                    "Fiona & Lucifera é um retrato bem-humorado do mundo dos humanos, onde reinam a ironia e o sarcasmo. Um livro cheio de pelos de gato e furos nas camisolas que o vai fazer rir do insólito das situações mais comuns do dia a dia.\n" +
                                    "Qualquer semelhança com a realidade, a minha ou a sua, não é apenas coincidência!', " +
                                    "'https://img.wook.pt/images/fiona-e-lucifera-fiona/MXwyNDE3NzU1NHwyMDI1MjA2MnwxNjE1NzY2NDAwMDAwfHdlYnA=/502x', " +
                                    "'Comédia', " +
                                    "'Fiona', " +
                                    "'2021', " +
                                    "1, '0', '0')");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Idiotas Úteis e Inúteis', " +
                                    "'Idiotas Úteis e Inúteis reúne mais de cem crónicas humorísticas que RAP escreveu originalmente para o jornal brasileiro de maior tiragem, a Folha de S. Paulo.\n" +
                                    "Da vida política brasileira à cirurgia cosmética facial de Rambo, da etiqueta respiratória sob pandemia ao teorema dos macacos infinitos, da higiene pessoal de James Bond ao cabeleireiro de Medusa, da infância Fortnite ao politicamente correcto, este volume percorre os temas caros ao comediante e o seu modo muito particular de observar o mundo.\n" +
                                    "\n" +
                                    "«Toda a gente tolera os idiotas úteis — que são, aliás, o melhor tipo de idiota. Os idiotas inúteis, pelo contrário, geram muito menos simpatia, uma vez que juntam a inutilidade à idiotice. Mas os idiotas úteis obtêm um certo tipo de redenção porque, sendo idiotas (uma circunstância infeliz da qual, em princípio, nem têm culpa), têm um préstimo. Se quiséssemos estabelecer uma hierarquia entre espertos úteis, espertos inúteis, idiotas úteis e idiotas inúteis, os idiotas úteis ocupariam um honroso segundo lugar, atrás dos espertos úteis mas à frente dos espertos inúteis, que, sendo embora espertos, não nos ajudam em nada.»', " +
                                    "'https://img.wook.pt/images/idiotas-uteis-e-inuteis-ricardo-araujo-pereira/MXwyNDM1NzUyM3wyMDQ0NjY2MHwxNjAxNDIwNDAwMDAwfHdlYnA=/502x', " +
                                    "'Comédia', " +
                                    "'Ricardo Araújo Pereira', " +
                                    "'2020', " +
                                    "12, '0', '0')");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Manual do Bom Fascista', " +
                                    "'Quanto de fascista há em si? Estará o fascismo entre nós ou dentro de nós?\n" +
                                    "\n" +
                                    "O Manual do Bom Fascista é um compêndio sobre a ascensão do fascismo dividido em 100 lições (ou mesmo mais) acessíveis a aprendizes de todos os níveis. Alguns dirão que este livro é uma chamada de atenção para o crescente poder do neofascismo, convidando a uma reflexão urgente sobre o modo como todos contribuímos para a propaganda desta ideologia. No entanto, talvez o livro seja mesmo apenas aquilo que parece: um manual de instruções para ajudar o leitor a descobrir o bom fascista que há em si, e como o alimentar melhor, quais as vitaminas a tomar, os exercícios a fazer, a fim de o aperfeiçoar. A bem da nação, obviamente.\n" +
                                    "Com amor e carinho, Rui Zink apresenta-nos um ensaio sobre a ideologia que voltou para assombrar os nossos dias e, se não nos pusermos a pau, os dos nossos bisnetos. Cientificamente concebido como guião, o Manual do Bom Fascista inclui casos que podem ser reais e um fascistómetro para o ajudar a ser um fascista bem-sucedido.', " +
                                    "'https://img.wook.pt/images/manual-do-bom-fascista-rui-zink/MXwyMzAzMDMxNXwxOTM2NjIwNnwxNTcxNzg1MjAwMDAwfHdlYnA=/502x', " +
                                    "'Comédia', " +
                                    "'Rui Zink', " +
                                    "'2020', " +
                                    "6, '0', '0')");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Os Benefícios de Dar Peidos', " +
                                    "'Traduzido pela primeira vez em português, Os Benefícios de Dar Peidos é um dos mais extraordinários e desassombrados textos satíricos de Jonathan Swift, o autor de As Viagens de Gulliver. Se dúvidas houvesse, bastaria ler o título completo: Os Benefícios de Dar Peidos Explicados ou A Causa Fundamental dos Episódios de Indisposição do Belo Sexo Investigada: Onde se prova, a posteriori, que a maioria dos mal-imundos que afligem as senhoras são culpa de flatulências não ventiladas oportunamente. A este texto junta-se outro texto de humor negro de Swift, Uma Proposta Modesta, no qual o autor recomenda que se comam as crianças pobres para assim resolver o problema da fome e da miséria da Irlanda do século XVIII. Duas obras-primas da sátira, num só livro.', " +
                                    "'https://img.wook.pt/images/os-beneficios-de-dar-peidos-jonathan-swift/MXwyNDU2MjM4N3wyMDY2ODIwNXwxNjA5Mjg2NDAwMDAwfHdlYnA=/502x', " +
                                    "'Comédia', " +
                                    "'Jonathan Swift', " +
                                    "'2021', " +
                                    "4, '0', '0')");

                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Ver para Crer', " +
                                    "'Aurélio Pereira fez a formação como jogador de futebol no Sporting Clube de Portugal, mas não chegou a sénior. Foi já com uma carreira de sucesso na área comercial que chegou a treinador, nas horas vagas, para ajudar o irmão. Treinou o Fofó e uma equipa de bancários que não eram bancários no campeonato do INATEL, até chegar novamente ao Sporting. E, a partir daí, fez história.\n" +
                                    "\n" +
                                    "Para ele, o jogador sempre foi o elo mais forte. Aurélio Pereira é um defensor ferrenho do futebol humanizado, não mecanizado. Aprendeu-o na escola da vida, onde as propinas são mais caras. Transportando atletas para os jogos no seu Mini cor de laranja, dando dormida a outros na sua própria casa, para poderem ir aos jogos, aproveitando fins de semana românticos para ir espreitar peladinhas, Aurélio Pereira tornou-se o maior caça-talentos do futebol mundial. Foram 62 os internacionais pela principal seleção portuguesa que lhe passaram pelas mãos. Nomes como Paulo Futre, Luís Figo ou Cristiano Ronaldo encabeçam uma lista que inclui dezenas de outros craques, nomeadamente Adrien, Beto, Cadete, Carlos Xavier, Dani, Gelson, Hugo Viana, João Mário, João Moutinho, Nani, Peixe, Quaresma, Rui Patrício ou William.\n" +
                                    "\n" +
                                    "Neste livro, está a montagem da primeira rede nacional de olheiros, estão as histórias de 50 anos dedicados ao Sporting e das descobertas mais proveitosas para o clube, para a seleção e para todos os adeptos de futebol.', " +
                                    "'https://img.wook.pt/images/ver-para-crer-rui-miguel-tovar/MXwyNDU3ODE5MXwyMDY5MDQ5MXwxNjIxMzc4ODAwMDAwfHdlYnA=/502x', " +
                                    "'Desporto', " +
                                    "'Rui Miguel Tovar e Aurélio Pereira', " +
                                    "'2021', " +
                                    "5, '0', '0')");

                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Uefa Euro 2020 - O Livro Oficial', " +
                                    "'A 16.ª edição do Campeonato Europeu de Futebol da UEFA terá lugar entre 11 de junho e 11 de julho de 2021, em 12 cidades espalhadas um pouco por toda a Europa, desde Dublin a Bacu e de São Petersburgo a Roma.\n" +
                                    "O UEFA EURO 2020: O Livro Oficial explora todo o torneio, incluindo uma análise pormenorizada dos países em jogo e as suas hipóteses de êxito; as estrelas que deverão estar nas primeiras páginas dos jornais; e ainda a recordação dos momentos mágicos de mais de 60 anos de competições gloriosas.\n" +
                                    "Repleto de factos e de estatísticas e com uma tabela para preencher à medida que o torneio decorre, o UEFA EURO 2020: O Livro Oficial é o guia perfeito para acompanhar a maior festa do futebol europeu.', " +
                                    "'https://img.wook.pt/images/uefa-euro-2020-o-livro-oficial/MXwyNDczNzcxNXwyMDg5OTQ3N3wxNjE5NDc4MDAwMDAwfHdlYnA=/502x', " +
                                    "'Desporto', " +
                                    "'Jubileu', " +
                                    "'2021', " +
                                    "9, '0', '0')");

                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Primeiro Dicionário Ilustrado de Inglês', " +
                                    "'Mais de 1000 palavras para aprenderes inglês de forma divertida!\n" +
                                    "\n" +
                                    "De A, como Actor, a Z, como Zoo, passando por Christmas, school ou tea time, vais descobrir não só a língua inglesa mas também o dia a dia dos ingleses.\n" +
                                    "\n" +
                                    "Este dicionário apresenta 25 páginas duplas sobre as tradições e a cultura dos britânicos e ainda algumas curiosidades.\n" +
                                    "\n" +
                                    "Graças às explicações simples, aos numerosos exemplos e à utilização das palavras em contexto, aprender inglês vai ser very, very, very easy!\n" +
                                    "\n" +
                                    "De acordo com as Metas Curriculares de Inglês para o 1.° Ciclo!', " +
                                    "'https://img.wook.pt/images/primeiro-dicionario-ilustrado-de-ingles-anne-sophie-le-breton/MXwxODAzOTc1NHwxOTIxMjMyNnwxNTY4MzI5MjAwMDAwfHdlYnA=/502x', " +
                                    "'Dicionário', " +
                                    "'Anne-Sophie Le Breton e Lemisse Al-Hafidh ', " +
                                    "'2021', " +
                                    "2, '0', '0')");

                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('Dicionário Básico Ilustrado da Língua Portuguesa (formato pequeno)', " +
                                    "'Nova edição do Dicionário Básico Ilustrado da Língua Portuguesa¸ totalmente revista e atualizada.\n" +
                                    "\n" +
                                    "Disponível em dois formatos, este dicionário foi concebido especialmente para os alunos do 1.º e 2.° Ciclos do Ensino Básico, com uma preocupação didática muito específica, e inclui:\n" +
                                    "mais de 11 500 entradas com indicação da divisão silábica, marcação da sílaba tónica e pronúncia das palavras estrangeiras;\n" +
                                    "definições redigidas numa linguagem rigorosa e muito clara;\n" +
                                    "mais de 350 ilustrações representando as definições e os conceitos apresentados\n" +
                                    "comentários e notas explicativas sobre dificuldades e particularidades da língua;\n" +
                                    "anexo com conteúdos gramaticais e conjugações verbais que esclarece as dúvidas gramaticais mais frequentes\n" +
                                    "Um dicionário fundamental para quem dá os primeiros passos na aprendizagem do português.', " +
                                    "'https://img.wook.pt/images/dicionario-basico-ilustrado-da-lingua-portuguesa-formato-pequeno/MXwxMjU3NDR8MjA4NDkzNjR8MTYxOTU2NDQwMDAwMHx3ZWJw/502x', " +
                                    "'Dicionário', " +
                                    "'Jubileu', " +
                                    "'2021', " +
                                    "15, '0', '0')");

                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('O Monstro das Cores\n" +
                                    "Caderno para colorir (6ª Edição)', " +
                                    "'As emoções explicadas às crianças através das cores.\n" +
                                    "A personagem principal é um monstro que muda de cor consoante o que está a sentir. Ele não percebe porque muda de cor e a sua amiga, a menina, explica-lhe o que significa estar triste, estar alegre, ter medo, estar calmo e sentir raiva.', " +
                                    "'https://img.wook.pt/images/o-monstro-das-cores-anna-llenas/MXwxNzAwMTc1NXwxMjYyMzk2M3wxNDczODk0MDAwMDAwfHdlYnA=/502x', " +
                                    "'Criança', " +
                                    "'Anna Llenas', " +
                                    "'2021', " +
                                    "20, '0', '0')");

                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber, isFavourite, wasReq) VALUES ('1001 Atividades Pré-escolares', " +
                                    "'Este livro foi elaborado para a criança em idade pré-escolar se divertir enquanto aprende.\n" +
                                    "\n" +
                                    "Através de atividades ludopedagógicas, baseadas nas Orientações Curriculares para a Educação Pré-escolar, pretende-se desenvolver as capacidades nas diferentes áreas e domínios, promovendo um harmonioso desenvolvimento infantil.', " +
                                    "'https://img.wook.pt/images/1001-atividades-pre-escolares/MXwyMTQxNjg0N3wyMDgxMDM4MHwxNjE1MzM0NDAwMDAwfHdlYnA=/502x', " +
                                    "'Criança', " +
                                    "'Jubileu', " +
                                    "'2021', " +
                                    "22, '0', '0')");



                            db.execSQL("INSERT INTO User (name, email, password) VALUES ('João Costa', '21143@stu.ipbeja.pt', '123')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
