package dnd.dndserver.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class CreateRandomNickName {
    static List<String> weathers = new ArrayList<String>(Arrays.asList(
            "맑은", "흐린", "비오는", "눈오는", "번개치는"
    ));
    static List<String> animals = new ArrayList<String>(Arrays.asList(
            "고양이", "강아지", "토끼", "판다", "코알라",
            "북극곰", "너구리", "다람쥐", "기린", "캥거루",
            "햄스터", "고슴도치", "치칠라", "페럿", "기니피그",
            "나무늘보", "레서판다", "슈가글라이더", "마모셋", "쿼카",
            // 이하 동일한 방식으로 추가
            "사슴", "펭귄", "오리너구리", "알파카", "미어캣",
            "벨루가", "아르마딜로", "코뿔소", "해마", "불가사리",
            "거북이", "카멜레온", "왈라비", "염소", "돌고래",
            "바다사자", "바다코끼리", "아기상어", "플라밍고", "참새",
            // 더 많은 동물을 추가하여 100까지 채워주세요.
            "양", "말", "여우", "늑대", "사자",
            "호랑이", "치타", "재규어", "스컹크", "물소",
            "하마", "기린", "코끼리", "사슴", "하이에나",
            "리스", "몽구스", "비버", "카피바라", "앵무새",
            "부엉이", "독수리", "매", "고래", "상어",
            "문어", "고래상어", "자라", "비단뱀", "악어",
            "코모도 드래곤", "타조", "카멜", "랫서판다", "쿠거",
            "스노우 레오파드", "북극여우", "오랑우탄", "고릴라", "침팬지"
    ));

    public static String generateRandomNickName() {
        Random random = new Random();
        String weather = weathers.get(random.nextInt(weathers.size()));
        String animal = animals.get(random.nextInt(animals.size()));
        return weather + " " + animal;
    }
}
