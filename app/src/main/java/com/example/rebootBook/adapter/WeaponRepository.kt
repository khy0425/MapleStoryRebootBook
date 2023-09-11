package com.example.rebootBook.adapter

import com.example.rebootBook.R
import com.example.rebootBook.dataClass.Brand
import com.example.rebootBook.dataClass.Category
import com.example.rebootBook.dataClass.Weapon
import com.example.rebootBook.dataClass.WeaponType

object WeaponRepository {
    private val weapons = listOf(
        // 파프니르
        Weapon(1, WeaponType.ONE_HAND_SWORD, "미스틸테인", mapOf("1추" to 68, "2추" to 53, "3추" to 40, "4추" to 29, "5추" to 20), R.drawable.p_one_hand_sword, Category.WARRIOR, Brand.PAPRIFIR),
        Weapon(2, WeaponType.ONE_HAND_AXE, "트윈클리버", mapOf("1추" to 68, "2추" to 53, "3추" to 40, "4추" to 29, "5추" to 20), R.drawable.p_one_hand_axe, Category.WARRIOR, Brand.PAPRIFIR),
        Weapon(3, WeaponType.ONE_HAND_BLUNT, "골디언해머", mapOf("1추" to 68, "2추" to 53, "3추" to 40, "4추" to 29, "5추" to 20), R.drawable.p_one_hand_blunt, Category.WARRIOR, Brand.PAPRIFIR),
        Weapon(4, WeaponType.TWO_HAND_SWORD, "페니텐시아", mapOf("1추" to 71, "2추" to 55, "3추" to 42, "4추" to 31, "5추" to 21), R.drawable.p_two_hand_sword, Category.WARRIOR, Brand.PAPRIFIR),
        Weapon(5, WeaponType.TWO_HAND_AXE, "배틀클리버", mapOf("1추" to 71, "2추" to 55, "3추" to 42, "4추" to 31, "5추" to 21), R.drawable.p_two_hand_axe, Category.WARRIOR, Brand.PAPRIFIR),
        Weapon(6, WeaponType.TWO_HAND_BLUNT, "라이트닝어", mapOf("1추" to 71, "2추" to 55, "3추" to 42, "4추" to 31, "5추" to 21), R.drawable.p_two_hand_blunt, Category.WARRIOR, Brand.PAPRIFIR),
        Weapon(8, WeaponType.LANCE, "브류나크", mapOf("1추" to 71, "2추" to 55, "3추" to 42, "4추" to 31, "5추" to 21), R.drawable.p_lance, Category.WARRIOR, Brand.PAPRIFIR),
        Weapon(9, WeaponType.POLEARM, "문글레이브", mapOf("1추" to 63, "2추" to 49, "3추" to 38, "4추" to 27, "5추" to 19), R.drawable.p_polearm, Category.WARRIOR, Brand.PAPRIFIR),
        Weapon(10, WeaponType.DEMON, "데스브링어", mapOf("1추" to 71, "2추" to 55, "3추" to 42, "4추" to 31, "5추" to 21), R.drawable.p_demon, Category.WARRIOR, Brand.PAPRIFIR),
        Weapon(11, WeaponType.BLASTER, "빅 마운틴", mapOf("1추" to 53, "2추" to 41, "3추" to 31, "4추" to 23, "5추" to 16), R.drawable.p_blaster, Category.WARRIOR, Brand.PAPRIFIR),
        Weapon(12, WeaponType.ADELE, "포기브니스", mapOf("1추" to 71, "2추" to 55, "3추" to 42, "4추" to 31, "5추" to 21), R.drawable.p_adele, Category.WARRIOR, Brand.PAPRIFIR),

        Weapon(13, WeaponType.WAND, "마나테이커", mapOf("1추" to 83, "2추" to 65, "3추" to 49, "4추" to 36, "5추" to 25), R.drawable.p_wand, Category.MAGICIAN, Brand.PAPRIFIR),
        Weapon(14, WeaponType.STAFF, "마나크라운", mapOf("1추" to 84, "2추" to 66, "3추" to 50, "4추" to 36, "5추" to 25), R.drawable.p_staff, Category.MAGICIAN, Brand.PAPRIFIR),
        Weapon(15, WeaponType.LUMI, "마나크래들", mapOf("1추" to 83, "2추" to 65, "3추" to 49, "4추" to 36, "5추" to 25), R.drawable.p_lumi, Category.MAGICIAN, Brand.PAPRIFIR),
        Weapon(16, WeaponType.ESP, "ESP리미터", mapOf("1추" to 83, "2추" to 65, "3추" to 49, "4추" to 36, "5추" to 25), R.drawable.p_esp, Category.MAGICIAN, Brand.PAPRIFIR),
        Weapon(17, WeaponType.ILLIUM, "매직 건틀렛", mapOf("1추" to 83, "2추" to 65, "3추" to 49, "4추" to 36, "5추" to 25), R.drawable.p_illium, Category.MAGICIAN, Brand.PAPRIFIR),

        Weapon(18, WeaponType.BOW, "윈드체이서", mapOf("1추" to 66, "2추" to 52, "3추" to 39, "4추" to 29, "5추" to 20), R.drawable.p_bow, Category.ARCHER, Brand.PAPRIFIR),
        Weapon(19, WeaponType.CROSSBOW, "윈드윙슈터", mapOf("1추" to 68, "2추" to 53, "3추" to 40, "4추" to 29, "5추" to 20), R.drawable.p_crossbow, Category.ARCHER, Brand.PAPRIFIR),
        Weapon(20, WeaponType.DUEL, "듀얼윈드윙", mapOf("1추" to 66, "2추" to 52, "3추" to 39, "4추" to 29, "5추" to 20), R.drawable.p_duel, Category.ARCHER, Brand.PAPRIFIR),
        Weapon(21, WeaponType.PATH, "에인션트 보우", mapOf("1추" to 66, "2추" to 52, "3추" to 39, "4추" to 29, "5추" to 20), R.drawable.p_path, Category.ARCHER, Brand.PAPRIFIR),
        Weapon(22, WeaponType.SHOOTER, "나이트체이서", mapOf("1추" to 66, "2추" to 52, "3추" to 39, "4추" to 29, "5추" to 20), R.drawable.p_shooter, Category.ARCHER, Brand.PAPRIFIR),

        Weapon(23, WeaponType.SHORT, "다마스커스", mapOf("1추" to 66, "2추" to 52, "3추" to 39, "4추" to 29, "5추" to 20), R.drawable.p_short, Category.THIEF, Brand.PAPRIFIR),
        Weapon(24, WeaponType.CLAW, "리스크홀더", mapOf("1추" to 36, "2추" to 28, "3추" to 21, "4추" to 16, "5추" to 11), R.drawable.p_claw, Category.THIEF, Brand.PAPRIFIR),
        Weapon(25, WeaponType.PHANTOM, "클레르시엘", mapOf("1추" to 68, "2추" to 53, "3추" to 40, "4추" to 29, "5추" to 20), R.drawable.p_phantom, Category.THIEF, Brand.PAPRIFIR),
        Weapon(26, WeaponType.ZENON, "스플릿엣지", mapOf("1추" to 53, "2추" to 41, "3추" to 31, "4추" to 23, "5추" to 16), R.drawable.p_zenon, Category.THIEF, Brand.PAPRIFIR),
        Weapon(27, WeaponType.CHAIN, "체인", mapOf("1추" to 66, "2추" to 52, "3추" to 39, "4추" to 29, "5추" to 20), R.drawable.p_chain, Category.THIEF, Brand.PAPRIFIR),
        Weapon(28, WeaponType.FAN, "용선", mapOf("1추" to 66, "2추" to 52, "3추" to 39, "4추" to 29, "5추" to 20), R.drawable.p_fan, Category.THIEF, Brand.PAPRIFIR),
        Weapon(29, WeaponType.KHALI, "차크람", mapOf("1추" to 66, "2추" to 52, "3추" to 39, "4추" to 29, "5추" to 20), R.drawable.p_khali, Category.THIEF, Brand.PAPRIFIR),

        Weapon(30, WeaponType.GUN, "첼리스카", mapOf("1추" to 52, "2추" to 40, "3추" to 31, "4추" to 22, "5추" to 15), R.drawable.p_gun, Category.PIRATE, Brand.PAPRIFIR),
        Weapon(31, WeaponType.KNUCKLE, "펜리르탈론", mapOf("1추" to 53, "2추" to 41, "3추" to 31, "4추" to 23, "5추" to 16), R.drawable.p_knuckle, Category.PIRATE, Brand.PAPRIFIR),
        Weapon(32, WeaponType.CANNON, "러스터캐논", mapOf("1추" to 72, "2추" to 56, "3추" to 43, "4추" to 31, "5추" to 21), R.drawable.p_canon, Category.PIRATE, Brand.PAPRIFIR),
        Weapon(33, WeaponType.ANGEL, "엔젤릭슈터", mapOf("1추" to 53, "2추" to 41, "3추" to 31, "4추" to 23, "5추" to 16), R.drawable.p_angel, Category.PIRATE, Brand.PAPRIFIR),
        Weapon(34, WeaponType.ZENON, "에너지체인", mapOf("1추" to 53, "2추" to 41, "3추" to 31, "4추" to 23, "5추" to 16), R.drawable.p_zenon, Category.PIRATE, Brand.PAPRIFIR),


        //앱솔랩스
        Weapon(35, WeaponType.ONE_HAND_SWORD, "세이버", mapOf("1추" to 101, "2추" to 79, "3추" to 60, "4추" to 44, "5추" to 30), R.drawable.e_one_hand_sword, Category.WARRIOR, Brand.EBSOLABS),
        Weapon(36, WeaponType.ONE_HAND_AXE, "엑스", mapOf("1추" to 101, "2추" to 79, "3추" to 60, "4추" to 44, "5추" to 30), R.drawable.e_one_hand_axe, Category.WARRIOR, Brand.EBSOLABS),
        Weapon(37, WeaponType.ONE_HAND_BLUNT, "비트해머", mapOf("1추" to 101, "2추" to 79, "3추" to 60, "4추" to 44, "5추" to 30), R.drawable.e_one_hand_blunt, Category.WARRIOR, Brand.EBSOLABS),
        Weapon(38, WeaponType.TWO_HAND_SWORD, "브로드세이버", mapOf("1추" to 106, "2추" to 82, "3추" to 63, "4추" to 46, "5추" to 31), R.drawable.e_two_hand_sword, Category.WARRIOR, Brand.EBSOLABS),
        Weapon(39, WeaponType.TWO_HAND_AXE, "브로드엑스", mapOf("1추" to 106, "2추" to 82, "3추" to 63, "4추" to 46, "5추" to 31), R.drawable.e_two_hand_axe, Category.WARRIOR, Brand.EBSOLABS),
        Weapon(40, WeaponType.TWO_HAND_BLUNT, "브로드해머", mapOf("1추" to 106, "2추" to 82, "3추" to 63, "4추" to 46, "5추" to 31), R.drawable.e_two_hand_blunt, Category.WARRIOR, Brand.EBSOLABS),
        Weapon(41, WeaponType.LANCE, "피어싱스피어", mapOf("1추" to 106, "2추" to 82, "3추" to 63, "4추" to 46, "5추" to 31), R.drawable.e_lance, Category.WARRIOR, Brand.EBSOLABS),
        Weapon(42, WeaponType.POLEARM, "헬버드", mapOf("1추" to 95, "2추" to 74, "3추" to 56, "4추" to 51, "5추" to 28), R.drawable.e_polearm, Category.WARRIOR, Brand.EBSOLABS),
        Weapon(43, WeaponType.DEMON, "데스페라도", mapOf("1추" to 106, "2추" to 82, "3추" to 63, "4추" to 46, "5추" to 31), R.drawable.e_demon, Category.WARRIOR, Brand.EBSOLABS),
        Weapon(44, WeaponType.BLASTER, "파일 갓", mapOf("1추" to 79, "2추" to 62, "3추" to 47, "4추" to 34, "5추" to 24), R.drawable.e_blaster, Category.WARRIOR, Brand.EBSOLABS),
        Weapon(45, WeaponType.ADELE, "튜너", mapOf("1추" to 106, "2추" to 82, "3추" to 63, "4추" to 46, "5추" to 31), R.drawable.e_adele, Category.WARRIOR, Brand.EBSOLABS),

        Weapon(46, WeaponType.WAND, "스펠링완드", mapOf("1추" to 124, "2추" to 97, "3추" to 73, "4추" to 54, "5추" to 37), R.drawable.e_wand, Category.MAGICIAN, Brand.EBSOLABS),
        Weapon(47, WeaponType.STAFF, "스펠링스태프", mapOf("1추" to 126, "2추" to 98, "3추" to 75, "4추" to 54, "5추" to 37), R.drawable.e_staff, Category.MAGICIAN, Brand.EBSOLABS),
        Weapon(48, WeaponType.LUMI, "샤이닝로드", mapOf("1추" to 124, "2추" to 97, "3추" to 73, "4추" to 54, "5추" to 37), R.drawable.e_lumi, Category.MAGICIAN, Brand.EBSOLABS),
        Weapon(49, WeaponType.ESP, " ESP리미터", mapOf("1추" to 124, "2추" to 97, "3추" to 73, "4추" to 54, "5추" to 37), R.drawable.e_esp, Category.MAGICIAN, Brand.EBSOLABS),
        Weapon(50, WeaponType.ILLIUM, "매직 건틀렛", mapOf("1추" to 124, "2추" to 97, "3추" to 73, "4추" to 54, "5추" to 37), R.drawable.e_illium, Category.MAGICIAN, Brand.EBSOLABS),

        Weapon(51, WeaponType.BOW, "슈팅보우", mapOf("1추" to 99, "2추" to 77, "3추" to 59, "4추" to 43, "5추" to 29), R.drawable.e_bow, Category.ARCHER, Brand.EBSOLABS),
        Weapon(52, WeaponType.CROSSBOW, "크로스보우", mapOf("1추" to 101, "2추" to 79, "3추" to 60, "4추" to 44, "5추" to 30), R.drawable.e_crossbow, Category.ARCHER, Brand.EBSOLABS),
        Weapon(53, WeaponType.DUEL, "듀얼보우건", mapOf("1추" to 99, "2추" to 77, "3추" to 59, "4추" to 43, "5추" to 29), R.drawable.e_duel, Category.ARCHER, Brand.EBSOLABS),
        Weapon(54, WeaponType.PATH, "에인션트 보우", mapOf("1추" to 99, "2추" to 77, "3추" to 59, "4추" to 43, "5추" to 29), R.drawable.e_path, Category.ARCHER, Brand.EBSOLABS),
        Weapon(55, WeaponType.SHOOTER, "브레스 슈터", mapOf("1추" to 99, "2추" to 77, "3추" to 59, "4추" to 43, "5추" to 29), R.drawable.e_shooter, Category.ARCHER, Brand.EBSOLABS),

        Weapon(56, WeaponType.SHORT, "슬래셔", mapOf("1추" to 99, "2추" to 77, "3추" to 59, "4추" to 43, "5추" to 29), R.drawable.e_short, Category.THIEF, Brand.EBSOLABS),
        Weapon(57, WeaponType.CLAW, "리벤지가즈", mapOf("1추" to 53, "2추" to 42, "3추" to 32, "4추" to 23, "5추" to 16), R.drawable.e_claw, Category.THIEF, Brand.EBSOLABS),
        Weapon(58, WeaponType.PHANTOM, "핀쳐케인", mapOf("1추" to 101, "2추" to 79, "3추" to 60, "4추" to 44, "5추" to 30), R.drawable.e_phantom, Category.THIEF, Brand.EBSOLABS),
        Weapon(59, WeaponType.ZENON, "에너지소드", mapOf("1추" to 79, "2추" to 62, "3추" to 47, "4추" to 34, "5추" to 24), R.drawable.e_zenon, Category.THIEF, Brand.EBSOLABS),
        Weapon(60, WeaponType.CHAIN, "체인", mapOf("1추" to 99, "2추" to 77, "3추" to 59, "4추" to 43, "5추" to 29), R.drawable.e_chain, Category.THIEF, Brand.EBSOLABS),
        Weapon(61, WeaponType.FAN, "괴선", mapOf("1추" to 99, "2추" to 77, "3추" to 59, "4추" to 43, "5추" to 29), R.drawable.e_fan, Category.THIEF, Brand.EBSOLABS),
        Weapon(62, WeaponType.KHALI, "차크람", mapOf("1추" to 99, "2추" to 77, "3추" to 59, "4추" to 43, "5추" to 29), R.drawable.e_khali, Category.THIEF, Brand.EBSOLABS),

        Weapon(63, WeaponType.GUN, "포인팅건", mapOf("1추" to 77, "2추" to 60, "3추" to 46, "4추" to 33, "5추" to 23), R.drawable.e_gun, Category.PIRATE, Brand.EBSOLABS),
        Weapon(64, WeaponType.KNUCKLE, "블로우너클", mapOf("1추" to 79, "2추" to 62, "3추" to 47, "4추" to 34, "5추" to 24), R.drawable.e_knuckle, Category.PIRATE, Brand.EBSOLABS),
        Weapon(65, WeaponType.CANNON, "블래스트캐논", mapOf("1추" to 108, "2추" to 84, "3추" to 64, "4추" to 47, "5추" to 32), R.drawable.e_canon, Category.PIRATE, Brand.EBSOLABS),
        Weapon(66, WeaponType.ANGEL, "소울슈터", mapOf("1추" to 79, "2추" to 62, "3추" to 47, "4추" to 34, "5추" to 24), R.drawable.e_angel, Category.PIRATE, Brand.EBSOLABS),
        Weapon(67, WeaponType.ZENON, "에너지체인", mapOf("1추" to 79, "2추" to 62, "3추" to 47, "4추" to 34, "5추" to 24), R.drawable.e_zenon, Category.PIRATE, Brand.EBSOLABS),

        // 아케인셰이드
        Weapon(68, WeaponType.ONE_HAND_SWORD, "세이버", mapOf("1추" to 175, "2추" to 136, "3추" to 103, "4추" to 75, "5추" to 51), R.drawable.a_one_hand_sword, Category.WARRIOR, Brand.ARCANESHADE),
        Weapon(69, WeaponType.ONE_HAND_AXE, "엑스", mapOf("1추" to 175, "2추" to 136, "3추" to 103, "4추" to 75, "5추" to 51), R.drawable.a_one_hand_axe, Category.WARRIOR, Brand.ARCANESHADE),
        Weapon(70, WeaponType.ONE_HAND_BLUNT, "해머", mapOf("1추" to 175, "2추" to 136, "3추" to 103, "4추" to 75, "5추" to 51), R.drawable.a_one_hand_blunt, Category.WARRIOR, Brand.ARCANESHADE),
        Weapon(71, WeaponType.TWO_HAND_SWORD, "투핸드소드", mapOf("1추" to 182, "2추" to 142, "3추" to 108, "4추" to 78, "5추" to 54), R.drawable.a_two_hand_sword, Category.WARRIOR, Brand.ARCANESHADE),
        Weapon(72, WeaponType.TWO_HAND_AXE, "투핸드엑스", mapOf("1추" to 182, "2추" to 142, "3추" to 108, "4추" to 78, "5추" to 54), R.drawable.a_two_hand_axe, Category.WARRIOR, Brand.ARCANESHADE),
        Weapon(73, WeaponType.TWO_HAND_BLUNT, "투핸드해머", mapOf("1추" to 182, "2추" to 142, "3추" to 108, "4추" to 78, "5추" to 54), R.drawable.a_two_hand_blunt, Category.WARRIOR, Brand.ARCANESHADE),
        Weapon(74, WeaponType.LANCE, "스피어", mapOf("1추" to 182, "2추" to 142, "3추" to 108, "4추" to 78, "5추" to 54), R.drawable.a_lance, Category.WARRIOR, Brand.ARCANESHADE),
        Weapon(75, WeaponType.POLEARM, "폴암", mapOf("1추" to 163, "2추" to 127, "3추" to 96, "4추" to 70, "5추" to 48), R.drawable.a_polearm, Category.WARRIOR, Brand.ARCANESHADE),
        Weapon(76, WeaponType.DEMON, "데스페라도", mapOf("1추" to 182, "2추" to 142, "3추" to 108, "4추" to 78, "5추" to 54), R.drawable.a_demon, Category.WARRIOR, Brand.ARCANESHADE),
        Weapon(77, WeaponType.BLASTER, "엘라하", mapOf("1추" to 136, "2추" to 106, "3추" to 81, "4추" to 59, "5추" to 40), R.drawable.a_blaster, Category.WARRIOR, Brand.ARCANESHADE),
        Weapon(78, WeaponType.ADELE, "튜너", mapOf("1추" to 182, "2추" to 142, "3추" to 108, "4추" to 78, "5추" to 54), R.drawable.a_adele, Category.WARRIOR, Brand.ARCANESHADE),

        Weapon(79, WeaponType.WAND, "완드", mapOf("1추" to 214, "2추" to 167, "3추" to 126, "4추" to 92, "5추" to 63), R.drawable.a_wand, Category.MAGICIAN, Brand.ARCANESHADE),
        Weapon(80, WeaponType.STAFF, "스태프", mapOf("1추" to 218, "2추" to 170, "3추" to 129, "4추" to 94, "5추" to 64), R.drawable.a_staff, Category.MAGICIAN, Brand.ARCANESHADE),
        Weapon(81, WeaponType.LUMI, "샤이닝로드", mapOf("1추" to 214, "2추" to 167, "3추" to 126, "4추" to 92, "5추" to 63), R.drawable.a_lumi, Category.MAGICIAN, Brand.ARCANESHADE),
        Weapon(82, WeaponType.ESP, "ESP리미터", mapOf("1추" to 214, "2추" to 167, "3추" to 126, "4추" to 92, "5추" to 63), R.drawable.a_esp, Category.MAGICIAN, Brand.ARCANESHADE),
        Weapon(83, WeaponType.ILLIUM, "매직 건틀렛", mapOf("1추" to 214, "2추" to 167, "3추" to 126, "4추" to 92, "5추" to 63), R.drawable.a_illium, Category.MAGICIAN, Brand.ARCANESHADE),

        Weapon(84, WeaponType.BOW, "보우", mapOf("1추" to 170, "2추" to 133, "3추" to 101, "4추" to 73, "5추" to 50), R.drawable.a_bow, Category.ARCHER, Brand.ARCANESHADE),
        Weapon(85, WeaponType.CROSSBOW, "크로스보우", mapOf("1추" to 175, "2추" to 136, "3추" to 103, "4추" to 75, "5추" to 51), R.drawable.a_crossbow, Category.ARCHER, Brand.ARCANESHADE),
        Weapon(86, WeaponType.DUEL, "듀얼보우건", mapOf("1추" to 170, "2추" to 133, "3추" to 101, "4추" to 73, "5추" to 50), R.drawable.a_duel, Category.ARCHER, Brand.ARCANESHADE),
        Weapon(87, WeaponType.PATH, "에인션트 보우", mapOf("1추" to 170, "2추" to 133, "3추" to 101, "4추" to 73, "5추" to 50), R.drawable.a_path, Category.ARCHER, Brand.ARCANESHADE),
        Weapon(88, WeaponType.SHOOTER, "브레스 슈터", mapOf("1추" to 170, "2추" to 133, "3추" to 101, "4추" to 73, "5추" to 50), R.drawable.a_shooter, Category.ARCHER, Brand.ARCANESHADE),

        Weapon(89, WeaponType.SHORT, "대거", mapOf("1추" to 170, "2추" to 133, "3추" to 101, "4추" to 73, "5추" to 50), R.drawable.a_short, Category.THIEF, Brand.ARCANESHADE),
        Weapon(90, WeaponType.CLAW, "가즈", mapOf("1추" to 92, "2추" to 72, "3추" to 55, "4추" to 40, "5추" to 27), R.drawable.a_claw, Category.THIEF, Brand.ARCANESHADE),
        Weapon(91, WeaponType.PHANTOM, "케인", mapOf("1추" to 175, "2추" to 136, "3추" to 103, "4추" to 75, "5추" to 51), R.drawable.a_phantom, Category.THIEF, Brand.ARCANESHADE),
        Weapon(92, WeaponType.ZENON, "에너지체인", mapOf("1추" to 136, "2추" to 106, "3추" to 81, "4추" to 59, "5추" to 40), R.drawable.a_zenon, Category.THIEF, Brand.ARCANESHADE),
        Weapon(93, WeaponType.CHAIN, "체인", mapOf("1추" to 170, "2추" to 133, "3추" to 101, "4추" to 73, "5추" to 50), R.drawable.a_chain, Category.THIEF, Brand.ARCANESHADE),
        Weapon(94, WeaponType.FAN, "초선", mapOf("1추" to 170, "2추" to 133, "3추" to 101, "4추" to 73, "5추" to 50), R.drawable.a_fan, Category.THIEF, Brand.ARCANESHADE),
        Weapon(95, WeaponType.KHALI, "차크람", mapOf("1추" to 170, "2추" to 133, "3추" to 101, "4추" to 73, "5추" to 50), R.drawable.a_khali, Category.THIEF, Brand.ARCANESHADE),

        Weapon(96, WeaponType.GUN, "피스톨", mapOf("1추" to 104, "2추" to 79, "3추" to 58, "4추" to 39, "5추" to 216), R.drawable.a_gun, Category.PIRATE, Brand.ARCANESHADE),
        Weapon(97, WeaponType.KNUCKLE, "클로", mapOf("1추" to 136, "2추" to 106, "3추" to 81, "4추" to 59, "5추" to 40), R.drawable.a_knuckle, Category.PIRATE, Brand.ARCANESHADE),
        Weapon(98, WeaponType.CANNON, "시즈건", mapOf("1추" to 186, "2추" to 145, "3추" to 110, "4추" to 80, "5추" to 55), R.drawable.a_canon, Category.PIRATE, Brand.ARCANESHADE),
        Weapon(99, WeaponType.ANGEL, "소울슈터", mapOf("1추" to 136, "2추" to 106, "3추" to 81, "4추" to 59, "5추" to 40), R.drawable.a_angel, Category.PIRATE, Brand.ARCANESHADE),
        Weapon(100, WeaponType.ZENON, "에너지체인", mapOf("1추" to 136, "2추" to 106, "3추" to 81, "4추" to 59, "5추" to 40), R.drawable.a_zenon, Category.PIRATE, Brand.ARCANESHADE),



        // 제네시스
        Weapon(101, WeaponType.ONE_HAND_SWORD, "세이버", mapOf("1추" to 201, "2추" to 157, "3추" to 119, "4추" to 87, "5추" to 59), R.drawable.g_one_hand_sword, Category.WARRIOR, Brand.GENESIS),
        Weapon(102, WeaponType.ONE_HAND_AXE, "엑스", mapOf("1추" to 201, "2추" to 157, "3추" to 119, "4추" to 87, "5추" to 59), R.drawable.g_one_hand_axe, Category.WARRIOR, Brand.GENESIS),
        Weapon(103, WeaponType.ONE_HAND_BLUNT, "해머", mapOf("1추" to 201, "2추" to 157, "3추" to 119, "4추" to 87, "5추" to 59), R.drawable.g_one_hand_blunt, Category.WARRIOR, Brand.GENESIS),
        Weapon(104, WeaponType.TWO_HAND_SWORD, "투핸드소드", mapOf("1추" to 210, "2추" to 164, "3추" to 124, "4추" to 90, "5추" to 62), R.drawable.g_two_hand_sword, Category.WARRIOR, Brand.GENESIS),
        Weapon(105, WeaponType.TWO_HAND_AXE, "투핸드엑스", mapOf("1추" to 210, "2추" to 164, "3추" to 124, "4추" to 90, "5추" to 62), R.drawable.g_two_hand_axe, Category.WARRIOR, Brand.GENESIS),
        Weapon(106, WeaponType.TWO_HAND_BLUNT, "투핸드해머", mapOf("1추" to 210, "2추" to 164, "3추" to 124, "4추" to 90, "5추" to 62), R.drawable.g_two_hand_blunt, Category.WARRIOR, Brand.GENESIS),
        Weapon(107, WeaponType.LANCE, "스피어", mapOf("1추" to 210, "2추" to 164, "3추" to 124, "4추" to 90, "5추" to 62), R.drawable.g_lance, Category.WARRIOR, Brand.GENESIS),
        Weapon(108, WeaponType.POLEARM, "폴암", mapOf("1추" to 187, "2추" to 146, "3추" to 111, "4추" to 81, "5추" to 55), R.drawable.g_polearm, Category.WARRIOR, Brand.GENESIS),
        Weapon(109, WeaponType.DEMON, "데스페라도", mapOf("1추" to 210, "2추" to 164, "3추" to 124, "4추" to 90, "5추" to 62), R.drawable.g_demon, Category.WARRIOR, Brand.GENESIS),
        Weapon(110, WeaponType.BLASTER, "엘라하", mapOf("1추" to 157, "2추" to 123, "3추" to 93, "4추" to 68, "5추" to 46), R.drawable.g_blaster, Category.WARRIOR, Brand.GENESIS),
        Weapon(111, WeaponType.ADELE, "튜너", mapOf("1추" to 210, "2추" to 164, "3추" to 124, "4추" to 90, "5추" to 62), R.drawable.g_adele, Category.WARRIOR, Brand.GENESIS),

        Weapon(112, WeaponType.WAND, "완드", mapOf("1추" to 250, "2추" to 195, "3추" to 148, "4추" to 108, "5추" to 74), R.drawable.g_wand, Category.MAGICIAN, Brand.GENESIS),
        Weapon(113, WeaponType.STAFF, "스태프", mapOf("1추" to 250, "2추" to 195, "3추" to 148, "4추" to 108, "5추" to 74), R.drawable.g_staff, Category.MAGICIAN, Brand.GENESIS),
        Weapon(114, WeaponType.LUMI, "샤이닝로드", mapOf("1추" to 246, "2추" to 192, "3추" to 146, "4추" to 106, "5추" to 72), R.drawable.g_lumi, Category.MAGICIAN, Brand.GENESIS),
        Weapon(115, WeaponType.ESP, "ESP 리미터", mapOf("1추" to 246, "2추" to 192, "3추" to 146, "4추" to 106, "5추" to 72), R.drawable.g_esp, Category.MAGICIAN, Brand.GENESIS),
        Weapon(116, WeaponType.ILLIUM, "매직 건틀렛", mapOf("1추" to 246, "2추" to 192, "3추" to 146, "4추" to 106, "5추" to 72), R.drawable.g_illium, Category.MAGICIAN, Brand.GENESIS),

        Weapon(117, WeaponType.BOW, "보우", mapOf("1추" to 196, "2추" to 153, "3추" to 116, "4추" to 84, "5추" to 58), R.drawable.g_bow, Category.ARCHER, Brand.GENESIS),
        Weapon(118, WeaponType.CROSSBOW, "크로스보우", mapOf("1추" to 201, "2추" to 157, "3추" to 119, "4추" to 87, "5추" to 59), R.drawable.g_crossbow, Category.ARCHER, Brand.GENESIS),
        Weapon(119, WeaponType.DUEL, "듀얼보우건", mapOf("1추" to 196, "2추" to 153, "3추" to 116, "4추" to 84, "5추" to 58), R.drawable.g_duel, Category.ARCHER, Brand.GENESIS),
        Weapon(120, WeaponType.PATH, "에인션트 보우", mapOf("1추" to 196, "2추" to 153, "3추" to 116, "4추" to 84, "5추" to 58), R.drawable.g_path, Category.ARCHER, Brand.GENESIS),
        Weapon(121, WeaponType.SHOOTER, "브레스 슈터", mapOf("1추" to 196, "2추" to 153, "3추" to 116, "4추" to 84, "5추" to 58), R.drawable.g_shooter, Category.ARCHER, Brand.GENESIS),

        Weapon(122, WeaponType.SHORT, "대거", mapOf("1추" to 196, "2추" to 153, "3추" to 116, "4추" to 84, "5추" to 58), R.drawable.g_short, Category.THIEF, Brand.GENESIS),
        Weapon(123, WeaponType.CLAW, "가즈", mapOf("1추" to 106, "2추" to 83, "3추" to 63, "4추" to 46, "5추" to 31), R.drawable.g_claw, Category.THIEF, Brand.GENESIS),
        Weapon(124, WeaponType.PHANTOM, "케인", mapOf("1추" to 201, "2추" to 157, "3추" to 119, "4추" to 87, "5추" to 59), R.drawable.g_phantom, Category.THIEF, Brand.GENESIS),
        Weapon(125, WeaponType.ZENON, "에너지체인", mapOf("1추" to 157, "2추" to 123, "3추" to 93, "4추" to 68, "5추" to 46), R.drawable.g_zenon, Category.THIEF, Brand.GENESIS),
        Weapon(126, WeaponType.CHAIN, "체인", mapOf("1추" to 196, "2추" to 153, "3추" to 116, "4추" to 84, "5추" to 58), R.drawable.g_chain, Category.THIEF, Brand.GENESIS),
        Weapon(127, WeaponType.FAN, "창세선", mapOf("1추" to 196, "2추" to 153, "3추" to 116, "4추" to 84, "5추" to 58), R.drawable.g_fan, Category.THIEF, Brand.GENESIS),
        Weapon(128, WeaponType.KHALI, "이클립스", mapOf("1추" to 196, "2추" to 153, "3추" to 116, "4추" to 84, "5추" to 58), R.drawable.g_khali, Category.THIEF, Brand.GENESIS),

        Weapon(129, WeaponType.GUN, "피스톨", mapOf("1추" to 154, "2추" to 120, "3추" to 91, "4추" to 66, "5추" to 45), R.drawable.g_gun, Category.PIRATE, Brand.GENESIS),
        Weapon(130, WeaponType.KNUCKLE, "클로", mapOf("1추" to 157, "2추" to 123, "3추" to 93, "4추" to 68, "5추" to 46), R.drawable.g_knuckle, Category.PIRATE, Brand.GENESIS),
        Weapon(131, WeaponType.CANNON, "시즈건", mapOf("1추" to 214, "2추" to 167, "3추" to 127, "4추" to 92, "5추" to 63), R.drawable.g_canon, Category.PIRATE, Brand.GENESIS),
        Weapon(132, WeaponType.ANGEL, "소울슈터", mapOf("1추" to 157, "2추" to 123, "3추" to 93, "4추" to 68, "5추" to 46), R.drawable.g_angel, Category.PIRATE, Brand.GENESIS),
        Weapon(133, WeaponType.ZENON, "에너지체인", mapOf("1추" to 157, "2추" to 123, "3추" to 93, "4추" to 68, "5추" to 46), R.drawable.g_zenon, Category.PIRATE, Brand.GENESIS)
    )

    fun getWeapons(): List<Weapon> {
        return weapons
    }

    fun getWeaponsByType(type: WeaponType): List<Weapon> {
        return weapons.filter { it.type == type }
    }

    fun getWeaponsByBrand(brand: Brand): List<Weapon> {
        return weapons.filter { it.brand == brand }
    }

}
