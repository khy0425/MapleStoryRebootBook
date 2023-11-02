package com.leaf.rebootBook.dataClass

enum class Job {
    WARRIOR, MAGICIAN, ARCHER, THIEF, PIRATE;

    fun getDisPlay(): String {
        return when (this) {
            WARRIOR -> "전사"
            MAGICIAN -> "마법사"
            ARCHER -> "궁수"
            THIEF -> "도적"
            PIRATE -> "해적"
            else -> this.name
        }
    }
}

enum class Stat {
    STR, DEX, INT, LUK, ATTACKMAGIC;
    fun getDisPlay(): String {
        return when (this) {
            STR -> "힘(STR)"
            DEX -> "민첩(DEX)"
            INT -> "지력(INT)"
            LUK -> "행운(LUK)"
            ATTACKMAGIC -> "공/마"
            else -> this.name
        }
    }
}

enum class AccessoryType {
    FACE_DECORATION, PENDANT;
    fun getDisPlay(): String {
        return when (this) {
            FACE_DECORATION -> "얼굴장식"
            PENDANT -> "펜던트"
            else -> this.name
        }
    }
}

enum class AlchemyRecipe {
    ATTACK_MAGIC, STAT, POTION;
    fun getDisPlay(): String {
        return when(this) {
            ATTACK_MAGIC -> "공격력/마력"
            STAT -> "스텟"
            POTION -> "비약"
            else -> this.name
        }
    }
}

enum class ThrowingStarRecipe {
    THROWING_STAR;

    fun getDisPlay(): String {
        return when(this) {
            THROWING_STAR -> "표창"
        }
    }
}

enum class UsageDuration {
    ONCE, DAILY, ETERNALLY;

    fun getDisPlay(): String {
        return when(this) {
            ONCE -> "1회"
            DAILY -> "1일"
            ETERNALLY -> "영구"
        }
    }
}

sealed class Acquisition {
    data class Monster(val name: String, val level: Int) : Acquisition()
    data class NPC(val name: String) : Acquisition()
}

data class ItemRecipe(
    val acquisition: List<Acquisition>,
    val name: String,
    val usageDuration: UsageDuration,
    val category: RecipeCategory
)

enum class ItemType {
    ACCESSORY, POTION, ThrowingStar;

    fun getDisPlay(): String {
        return when (this) {
            ACCESSORY -> "악세"
            POTION -> "도핑"
            ThrowingStar -> "표창"
            else -> this.name
        }
    }
}


data class RecipeCategory(
    val imageRes: Int,
    val jobs: List<Job>,
    val stats: List<Stat>,
    val type: ItemType,
    val subCategory: SubCategory
)

sealed class SubCategory

data class AccessorySubCategory(val type: AccessoryType) : SubCategory()

data class AlchemySubCategory(val type: AlchemyRecipe) : SubCategory()

data class ThrowingStarSubCategory(val type: ThrowingStarRecipe) : SubCategory()