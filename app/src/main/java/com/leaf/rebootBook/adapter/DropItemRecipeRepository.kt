package com.leaf.rebootBook.adapter

import com.leaf.rebootBook.R
import com.leaf.rebootBook.dataClass.AccessorySubCategory
import com.leaf.rebootBook.dataClass.AccessoryType
import com.leaf.rebootBook.dataClass.Acquisition
import com.leaf.rebootBook.dataClass.AlchemyRecipe
import com.leaf.rebootBook.dataClass.AlchemySubCategory
import com.leaf.rebootBook.dataClass.ItemRecipe
import com.leaf.rebootBook.dataClass.ItemType
import com.leaf.rebootBook.dataClass.Job
import com.leaf.rebootBook.dataClass.RecipeCategory
import com.leaf.rebootBook.dataClass.Stat
import com.leaf.rebootBook.dataClass.ThrowingStarRecipe
import com.leaf.rebootBook.dataClass.ThrowingStarSubCategory
import com.leaf.rebootBook.dataClass.UsageDuration
object DropItemRecipeRepository {
    private fun createAccessoryCategory(jobs: List<Job>, stats: List<Stat>, type: AccessoryType): RecipeCategory {
        return RecipeCategory(
            imageRes = R.drawable.accessory_recipe,
            jobs = jobs,
            stats = stats,
            type = ItemType.ACCESSORY,
            subCategory = AccessorySubCategory(type)
        )
    }

    private fun createPotionCategory(jobs: List<Job>, stats: List<Stat>, type: AlchemyRecipe) : RecipeCategory {
        return RecipeCategory(
            imageRes = R.drawable.consumable_recipe,
            jobs = jobs,
            stats = stats,
            type = ItemType.POTION,
            subCategory = AlchemySubCategory(type)
        )
    }

    private fun createStarCategory(jobs: List<Job>, stats: List<Stat>, type: ThrowingStarRecipe) : RecipeCategory {
        return RecipeCategory(
            imageRes = R.drawable.weapon_recipe,
            jobs = jobs,
            stats = stats,
            type = ItemType.ThrowingStar,
            subCategory = ThrowingStarSubCategory(type)
        )
    }

    //얼굴 장식
    private val warriorStrFaceDecorationCategory = createAccessoryCategory(listOf(Job.WARRIOR), listOf(
        Stat.STR), AccessoryType.FACE_DECORATION)
    private val archerDexFaceDecorationCategory = createAccessoryCategory(listOf(Job.ARCHER), listOf(
        Stat.DEX), AccessoryType.FACE_DECORATION)
    private val thiefLukFaceDecorationCategory = createAccessoryCategory(listOf(Job.THIEF), listOf(
        Stat.LUK), AccessoryType.FACE_DECORATION)
    private val magicianIntFaceDecorationCategory = createAccessoryCategory(listOf(Job.MAGICIAN), listOf(
        Stat.INT), AccessoryType.FACE_DECORATION)
    private val pirateMultiFaceDecorationCategory = createAccessoryCategory(listOf(Job.PIRATE), listOf(
        Stat.STR, Stat.DEX), AccessoryType.FACE_DECORATION)

    //펜던트
    private val warriorStrPendantCategory = createAccessoryCategory(listOf(Job.WARRIOR, Job.PIRATE), listOf(
        Stat.STR), AccessoryType.PENDANT)
    private val archerDexPendantCategory = createAccessoryCategory(listOf(Job.ARCHER, Job.PIRATE), listOf(
        Stat.DEX), AccessoryType.PENDANT)
    private val magicianIntPendantCategory = createAccessoryCategory(listOf(Job.MAGICIAN), listOf(
        Stat.INT), AccessoryType.PENDANT)
    private val thiefLukPendantCategory = createAccessoryCategory(listOf(Job.THIEF), listOf(Stat.LUK), AccessoryType.PENDANT)

    //물약 (공, 마)
    private val enhancedAttakPotion = createPotionCategory(listOf(Job.WARRIOR, Job.ARCHER, Job.THIEF, Job.PIRATE), listOf(
        Stat.STR, Stat.LUK, Stat.DEX), AlchemyRecipe.ATTACK_MAGIC)
    private val enhancedMagiPotion = createPotionCategory(listOf(Job.MAGICIAN), listOf(Stat.INT), AlchemyRecipe.ATTACK_MAGIC)

    //물약 (주스텟)
    private val enhancedStrPotion = createPotionCategory(listOf(Job.WARRIOR, Job.PIRATE), listOf(
        Stat.STR), AlchemyRecipe.STAT)
    private val enhancedDexPotion = createPotionCategory(listOf(Job.ARCHER, Job.PIRATE), listOf(Stat.DEX), AlchemyRecipe.STAT)
    private val enhancedIntPotion = createPotionCategory(listOf(Job.MAGICIAN), listOf(Stat.INT), AlchemyRecipe.STAT)
    private val enhancedLukPotion = createPotionCategory(listOf(Job.THIEF), listOf(Stat.LUK), AlchemyRecipe.STAT)

    //비약
    private val legendHeroPotion = createPotionCategory(listOf(Job.WARRIOR, Job.ARCHER, Job.MAGICIAN, Job.THIEF, Job.PIRATE),
        listOf(Stat.ATTACKMAGIC), AlchemyRecipe.POTION)

    //표창
    private val infinityStar = createStarCategory(listOf(Job.THIEF), listOf(Stat.LUK), ThrowingStarRecipe.THROWING_STAR)
    private val frameStar = createStarCategory(listOf(Job.THIEF), listOf(Stat.LUK), ThrowingStarRecipe.THROWING_STAR)

    private val recipes = listOf(
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "스펙터 전투견", level = 95),
                Acquisition.Monster(name = "예티", level = 117),
                Acquisition.Monster(name = "붉은 도깨비", level = 136),
                Acquisition.Monster(name = "블루 와이번", level = 137),
                Acquisition.Monster(name = "변형된 티루", level = 165)
            ),
            name = "샤이니 레드 워리어 심볼",
            usageDuration = UsageDuration.ONCE,
            category = warriorStrFaceDecorationCategory
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "콜드샤크", level = 110),
                Acquisition.Monster(name = "[★]소울테니", level = 115),
                Acquisition.Monster(name = "라이칸스로프", level = 123),
                Acquisition.Monster(name = "그린 코니언", level = 136),
                Acquisition.Monster(name = "릴리노흐", level = 150)
            ),
            name = "샤이니 레드 아처 심볼",
            usageDuration = UsageDuration.ONCE,
            category = archerDexFaceDecorationCategory
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "예티와 페페", level = 120),
                Acquisition.Monster(name = "그레이 벌쳐", level = 125),
                Acquisition.Monster(name = "스켈로스", level = 153),
                Acquisition.Monster(name = "머신 MT-09", level = 177),
                Acquisition.Monster(name = "상급기사A", level = 177),
                Acquisition.Monster(name = "드론 화이트", level = 178)
            ),
            name = "샤이니 레드 매지션 심볼",
            usageDuration = UsageDuration.ONCE,
            category = magicianIntFaceDecorationCategory
        ),
        ItemRecipe(
            acquisition = listOf(
            Acquisition.Monster(name = "[★]클라크", level = 116),
            Acquisition.Monster(name = "플라이 아이", level = 122),
            Acquisition.Monster(name = "힘센 돌도깨비", level = 137),
            Acquisition.Monster(name = "후회의 사제", level = 146),
            Acquisition.Monster(name = "망각의 수호대장", level = 154)
        ),
            name = "샤이니 레드 시프 심볼",
            usageDuration = UsageDuration.ONCE,
            category = thiefLukFaceDecorationCategory
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "[★]데스테니", level = 118),
                Acquisition.Monster(name = "도라지", level = 139),
                Acquisition.Monster(name = "뉴그레이 블랙", level = 175),
                Acquisition.Monster(name = "다크니스", level = 175)
            ),
            name = "샤이니 레드 파이렛 심볼",
            usageDuration = UsageDuration.ONCE,
            category = pirateMultiFaceDecorationCategory
        ),
        //펜던트
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "광석 이터", level = 85),
                Acquisition.Monster(name = "하프", level = 106),
                Acquisition.Monster(name = "정예 스켈레톤 나이트", level = 110),
                Acquisition.Monster(name = "추억의 수호대장", level = 144)
            ),
            name = "베어스 퍼플 펜던트",
            usageDuration = UsageDuration.ONCE,
            category = warriorStrPendantCategory
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "그레이 벌처", level = 125),
                Acquisition.Monster(name = "후회의 수호대장", level = 149),
                Acquisition.Monster(name = "[★]스켈로스", level = 153)
            ),
            name = "울프스 퍼플 펜던트",
            usageDuration = UsageDuration.ONCE,
            category = archerDexPendantCategory
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "레인디어", level = 118),
                Acquisition.Monster(name = "캐슬 골렘", level = 127),
                Acquisition.Monster(name = "변형된 티구르", level = 167),
                Acquisition.Monster(name = "플라티안", level = 167)
            ),
            name = "아울스 퍼플 펜던트",
            usageDuration = UsageDuration.ONCE,
            category = magicianIntPendantCategory
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "듀얼 버크", level = 109),
                Acquisition.Monster(name = "[★]기간틱 바이킹", level = 119),
                Acquisition.Monster(name = "추억의 수호병", level = 143),
                Acquisition.Monster(name = "정식기사A", level = 168)
            ),
            name = "피콕스 퍼플 펜던트",
            usageDuration = UsageDuration.ONCE,
            category = thiefLukPendantCategory
        ),
        //5단계 공격력 물약, 향상된 물약
        ItemRecipe(
            acquisition = listOf(
                Acquisition.NPC(name = "마이스터빌 지뉴")
            ),
            name = "5단계 공격력 물약",
            usageDuration = UsageDuration.DAILY,
            category = enhancedAttakPotion
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "검은 켄타우로스", level = 110),
                Acquisition.Monster(name = "추억의 수호병", level = 143),
                Acquisition.Monster(name = "후회의 신관", level = 147),
                Acquisition.Monster(name = "망각의 수호대장", level = 154),
                Acquisition.Monster(name = "정식기사 C", level = 172),
                Acquisition.Monster(name = "드론 블랙", level = 179),
                Acquisition.Monster(name = "상급기사B", level = 179)
            ),
            name = "향상된 5단계 공격력 물약",
            usageDuration = UsageDuration.ETERNALLY,
            category = enhancedAttakPotion
        ),
        //5단계 마력 물약, 향상된 물약
        ItemRecipe(
            acquisition = listOf(
                Acquisition.NPC(name = "마이스터빌 지뉴")
            ),
            name = "5단계 마력 물약",
            usageDuration = UsageDuration.DAILY,
            category = enhancedMagiPotion
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "호브", level = 104),
                Acquisition.Monster(name = "모래 두더지", level = 114),
                Acquisition.Monster(name = "블루 드래곤터틀", level = 127),
                Acquisition.Monster(name = "[★]마이너 좀비", level = 132),
                Acquisition.Monster(name = "[★]불독", level = 134),
                Acquisition.Monster(name = "그린코니언", level = 136),
                Acquisition.Monster(name = "[★]정식기사D", level = 174),
                Acquisition.Monster(name = "정식기사E", level = 176),
                Acquisition.Monster(name = "메카티안", level = 176),
            ),
            name = "향상된 5단계 마력 물약",
            usageDuration = UsageDuration.ETERNALLY,
            category = enhancedMagiPotion
        ),
        //9단계 힘의 물약, 향상된 물약
        ItemRecipe(
            acquisition = listOf(
                Acquisition.NPC(name = "마이스터빌 지뉴")
            ),
            name = "★9단계 힘의 물약",
            usageDuration = UsageDuration.DAILY,
            category = enhancedStrPotion
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "판스", level = 123),
                Acquisition.Monster(name = "블루 드래곤터틀", level = 127),
                Acquisition.Monster(name = "[★]마이너 좀비", level = 132),
                Acquisition.Monster(name = "추억의 수호대장", level = 144),
                Acquisition.Monster(name = "정식기사E", level = 176),
                Acquisition.Monster(name = "메카티안", level = 176),
            ),
            name = "★향상된 9단계 힘의 물약",
            usageDuration = UsageDuration.ETERNALLY,
            category = enhancedStrPotion
        ),
        //10단계 힘의 물약, 향상된 물약
        ItemRecipe(
            acquisition = listOf(
                Acquisition.NPC(name = "마이스터빌 지뉴")
            ),
            name = "10단계 힘의 물약",
            usageDuration = UsageDuration.DAILY,
            category = enhancedStrPotion
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "예티", level = 117),
                Acquisition.Monster(name = "스켈레곤", level = 147),
                Acquisition.Monster(name = "타락한 시간의 수호대장", level = 164),
            ),
            name = "향상된 10단계 힘의 물약",
            usageDuration = UsageDuration.ETERNALLY,
            category = enhancedStrPotion
        ),
        //9단계 지능의 물약, 향상된 물약
        ItemRecipe(
            acquisition = listOf(
                Acquisition.NPC(name = "마이스터빌 지뉴")
            ),
            name = "★9단계 지능의 물약",
            usageDuration = UsageDuration.DAILY,
            category = enhancedIntPotion
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "레인디어", level = 118),
                Acquisition.Monster(name = "베어울프", level = 122),
                Acquisition.Monster(name = "후회의 신관", level = 147),
                Acquisition.Monster(name = "정식기사E", level = 176),
                Acquisition.Monster(name = "메카티안", level = 176),
            ),
            name = "★향상된 9단계 지능의 물약",
            usageDuration = UsageDuration.ETERNALLY,
            category = enhancedIntPotion
        ),
        //10단계 지능의 물약, 향상된 물약
        ItemRecipe(
            acquisition = listOf(
                Acquisition.NPC(name = "마이스터빌 지뉴")
            ),
            name = "10단계 지능의 물약",
            usageDuration = UsageDuration.DAILY,
            category = enhancedIntPotion
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "예티", level = 117),
                Acquisition.Monster(name = "레드 와이번", level = 134),
                Acquisition.Monster(name = "라이트닝", level = 177),
            ),
            name = "향상된 10단계 지능의 물약",
            usageDuration = UsageDuration.ETERNALLY,
            category = enhancedIntPotion
        ),

        //10단계 민첩의 물약, 향상된 물약
        ItemRecipe(
            acquisition = listOf(
                Acquisition.NPC(name = "마이스터빌 지뉴")
            ),
            name = "10단계 민첩의 물약",
            usageDuration = UsageDuration.DAILY,
            category = enhancedDexPotion
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "웨어울프", level = 122),
                Acquisition.Monster(name = "뉴트주니어", level = 145),
            ),
            name = "향상된 10단계 민첩의 물약",
            usageDuration = UsageDuration.ETERNALLY,
            category = enhancedDexPotion
        ),
        //10단계 행운의 물약, 향상된 물약
        ItemRecipe(
            acquisition = listOf(
                Acquisition.NPC(name = "마이스터빌 지뉴")
            ),
            name = "10단계 행운의 물약",
            usageDuration = UsageDuration.DAILY,
            category = enhancedLukPotion
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "파이렛", level = 118),
                Acquisition.Monster(name = "네스트골렘", level = 150),
                Acquisition.Monster(name = "소울", level = 169),
                Acquisition.Monster(name = "정식기사D", level = 174),
            ),
            name = "향상된 10단계 행운의 물약",
            usageDuration = UsageDuration.ETERNALLY,
            category = enhancedLukPotion
        ),
        //전설의 영웅 비약
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "[★]증기뿜는 커피머신", level = 155),
                Acquisition.Monster(name = "망각의 수호병", level = 164),
                Acquisition.Monster(name = "정식기사B", level = 170),
                Acquisition.Monster(name = "상급기사A", level = 177),
            ),
            name = "전설의 영웅 비약",
            usageDuration = UsageDuration.DAILY,
            category = legendHeroPotion
        ),
        //표창
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "이끼 달팽이", level = 98),
                Acquisition.Monster(name = "[★]소울테니", level = 115),
            ),
            name = "무한의 수리검",
            usageDuration = UsageDuration.ONCE,
            category = infinityStar
        ),
        ItemRecipe(
            acquisition = listOf(
                Acquisition.Monster(name = "[★]G.팬텀워치", level = 119),
                Acquisition.Monster(name = "네스트골렘", level = 150),
                Acquisition.Monster(name = "맨티스", level = 152),
                Acquisition.Monster(name = "블러드 맨티스", level = 153),
                Acquisition.Monster(name = "포이즌 맨티스", level = 154),
                Acquisition.Monster(name = "다크니스", level = 175),
                Acquisition.Monster(name = "라이트닝", level = 177),
            ),
            name = "플레임 표창",
            usageDuration = UsageDuration.ONCE,
            category = frameStar
        )
    )

    fun getItemRecipeByJob(job: Job): List<ItemRecipe> {
        return recipes.filter { it.category.jobs.contains(job) }
    }
    fun getItemRecipeByStat(stats: Stat): List<ItemRecipe> {
        return recipes.filter { it.category.stats.contains(stats) }
    }
    fun getItemRecipeByItemType(itemType: ItemType): List<ItemRecipe> {
        return recipes.filter { it.category.type == itemType }
    }

    fun getRecipes(): List<ItemRecipe> {
        return recipes
    }

}