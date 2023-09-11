package com.example.rebootBook.dataClass

data class Weapon(
    val id: Int,
    val type: WeaponType,
    val name: String,
    val options: Map<String, Int>,
    val imageResId: Int,
    val category: Category,
    val brand: Brand
)

enum class WeaponType {
    TWO_HAND_SWORD, ONE_HAND_SWORD, TWO_HAND_AXE, ONE_HAND_AXE, TWO_HAND_BLUNT, ONE_HAND_BLUNT, ADELE, BLASTER, DEMON, LANCE, POLEARM,
    ESP, ILLIUM, LUMI, STAFF, WAND,
    BOW, CROSSBOW, DUEL, PATH, SHOOTER,
    SHORT, CLAW, PHANTOM, ZENON, CHAIN, FAN, KHALI,
    ANGEL, CANNON, GUN, KNUCKLE,
    ZERO;

    fun getDisPlay(): String {
        return when (this) {
            TWO_HAND_SWORD -> "두손검"
            ONE_HAND_SWORD -> "한손검"
            TWO_HAND_AXE -> "두손도끼"
            ONE_HAND_AXE -> "한손도끼"
            TWO_HAND_BLUNT -> "두손둔기"
            ONE_HAND_BLUNT -> "한손둔기"
            ADELE -> "튜너"
            BLASTER -> "건틀렛 리볼버"
            DEMON -> "데스페라도"
            LANCE -> "창"
            POLEARM -> "폴암"
            ESP -> "ESP 리미터"
            ILLIUM -> "매직 건틀렛"
            LUMI -> "샤이닝 로드"
            STAFF -> "스태프"
            WAND -> "완드"
            BOW -> "활"
            CROSSBOW -> "석궁"
            DUEL -> "듀얼 보우건"
            PATH -> "에인션트 보우"
            SHOOTER -> "브레스 슈터"
            SHORT -> "단검"
            CLAW -> "아대"
            PHANTOM -> "케인"
            ZENON -> "에너지 소드"
            FAN -> "부채"
            KHALI -> "차크람"
            ANGEL -> "소울 슈터"
            CANNON -> "핸드캐논"
            GUN -> "건"
            KNUCKLE -> "너클"
            ZERO -> "대검&태도"
            else -> this.name
        }
    }
}

enum class Category {
    WARRIOR, MAGICIAN, ARCHER, THIEF, PIRATE
}

enum class Brand(val prefix: String) {
    PAPRIFIR("p"),
    EBSOLABS("e"),
    ARCANESHADE("a"),
    GENESIS("g")
}
