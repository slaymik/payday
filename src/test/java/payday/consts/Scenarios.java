package payday.consts;

import java.util.ArrayList;
import java.util.List;

public class Scenarios {
    public static List<List<String>> scenarios = new ArrayList<>();
    public static String[] scenarioTexts = {
    "Вы выходите из фургона и надеваете маску клоуна. Вы врываетесь в ювелирный магазин. Вы убиваете охранников и отвечаете на пейджеры. Вы связывате гражданских. Вы убивате гражданских. Нахуя вы связывали гражданских тогда? Ладно похуй. Вы забираете всю ювелирку на дисплеях в карманы. Вы замечаете сейф в кабинете управляющего. Вы взламываете сейф отмычкой. Вы складываете в сумки паллеты с ювелирными украшениями. Вы переносите сумки в машину. Вы уезжаете в убежище с награбленным.",
    "Вы сидите за рулем черной гоночной машины, стоящей в темной уличной аллее, напротив банка. Перед началом миссии, вы проверяете свое снаряжение: ваше оружие готово к действию, маска закрывает ваше лицо, и средства связи на месте. Вы выходите из машины и заходите в банк. Вы откючаете все камеры и кнопки тревоги. Перед вами стоит манументальный банковский сейф, хорошо, что вы прихватили с собой термобур. Вы подключили термобур и начали сверлить дверь сейфа. Бжжжжжж. Бжжжжжж. Бжжжжжж. Черт! Бур заклинило. Вы хуярите прикладом по буру, но он не чинится. Пришлось чинить вручную. Бур закончил сверлить. Перед вами открывается дверь сейфа, набитого свежими купюрами. Вы складываете купюры в мешки. Вы переносите мешки в машину. Вы уезжаете в убежище."  ,
    "Вы сидите в фургоне и осматриваете ваши цели: четыре магазина, принадлежащие конкуренту Влада. Ваша задача - помешать их работе любым способом. Вы заходите в первый магазин: Китайскую сувенирную лавку. Надев маску, вы угрожаете продавцу и связываете ему руки. Вы вытаскиваете все деньги из кассы и разбиваете товар. Перед уходом вы решили приспустить штаны и насрать на связанного продавца. Аккуратно перебегаем во второй магазин: reStore. По той же схеме связываем продавца. Вместо того, чтобы разбивать товар, вы решили сделать фотографии своих гениталий на всех устройствах в магазине. В это время связанный продавец рассказывает вам о преимуществах нового iPhone 15 и рекомендует его к покупке. С грацией пумы перебегаем в третий магазин: Пиццерию Джо. За прилавком вы видите подозрительно знакомого человека и узнаете в нем своего друга Даню. Из-за этого вы решили не мешать работе пиццерии, а просто заказать с собой пепперони с сырным бортом. Забрав пиццу вы передвигатесь по переулку к последнему магазину: Мини-маркет «9/11». Вам стало лень связывать кассира и вы просто убили его. Теперь нужно обязательно поприседать на его трупе. Вы забираете деньги из кассы, опракидываете пару холодильников с напитками и выходите из магазины. Пора отправляться в убежище и ждать награды за свои старания.",
    "Вы подъезжаете к магазину. Вы выходите из машины. Вы обследуете периметр магазина. Вы замечаете 2 двери: одна ведет в комнату с охранником, который смотрит на камеры, вторая - это задний вход в магазин. Вы взламываете дверь. Вы убиваете охранника на камерах. Вы аккуратно заходите в магазин через задний вход. Вы ждете удобного момента, чтобы убить менеджера и забрать его ключ-карту. Вы убиваете менеджера и забираете ключ карту. Вы убиваеете остальных охранников. Вы отключаете сигнализацию на витринах с помощью ключ-карты менеджера. Вы пакуте все палеты с драгоценностями. Вы распихивате все украшения на дисплеях по карманам. Вы переносите сумки с драгоценностями в машину. Вы уезжате в убежище.",
    "Вы замечаете свою цель: Колонну инкассаторских грузовик с деньгами. Грузовики проезжают по заранее установленной ленте с шипами и останавливаются. Вы выходите из своей машины, и ваш друг-водитель Райан Гослинг говорит, что он уедет через 5 минут и точно не умрет в конце, 100%. Вы угрожаете водителям грузовиков оружием и они выходят из машин. Вы связываете водителей и кладете их на землю. Вы ставите дрели на двери каждого грузовика, надеясь, что они не заклинят. Бжжжжжж. Бжжжжж. Бжжжжж. Да как так то блять все сломались разом какого хуя. Вы успокоились и починили все дрели с удара. Дрели закончили работу. Вы достаете свою пилу и вскрываете ячейки в грузовиках. Вы пакуете все ценное из ячеек. Вы перетаскиваете сумки в машину. Вы уезжаете вместе с Райаном Гослингом в убежище и точно не умираете в конце."

};

    static {
        for (int i = 0; i < scenarioTexts.length; i++) {
            List<String> scenario = new ArrayList<>();
            initializeScenario(scenarioTexts[i], scenario);
            scenarios.add(scenario);
        }
    }

    private static void initializeScenario(String text, List<String> scenarioList) {
        String[] sentences = text.split("\\.");
        for (String sentence : sentences) {
            scenarioList.add(sentence.trim() + ".");
        }
    }
}
