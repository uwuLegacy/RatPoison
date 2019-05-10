package rat.poison.scripts.aim

import rat.poison.convStrToArray
import rat.poison.curSettings
import rat.poison.game.Weapons
import rat.poison.game.entity.weapon
import rat.poison.game.me
import rat.poison.settingsLoaded
import rat.poison.strToBool
import rat.poison.utils.every

var override = false
var curWep = Weapons.AK47

fun setAim() = every(128){

//        if (!saving && settingsLoaded) {
//        if (curWepCheck != me.weapon())
//        {
//            curWepCheck = me.weapon()
//        }
//        if (curWepCheck.rifle || curWepCheck.smg || curWepCheck.pistol || curWepCheck.sniper || curWepCheck.shotgun) {
//            val curWep: DoubleArray = engine.eval(curWepCheck.name) as DoubleArray
//
//            if (curWep[1].toBool()) {
//                FACTOR_RECOIL = curWep[2].toBool()
//                ENABLE_FLAT_AIM = curWep[3].toBool()
//                ENABLE_PATH_AIM = curWep[4].toBool()
//                AIM_BONE = curWep[5].toInt()
//                AIM_FOV = curWep[6].toInt()
//                AIM_SPEED = curWep[7].toInt()
//                AIM_SMOOTHNESS = curWep[8]
//                PERFECT_AIM = curWep[10].toBool()
//                PERFECT_AIM_FOV = curWep[11].toInt()
//                PERFECT_AIM_CHANCE = curWep[12].toInt()
//                override = true
//            } else {
//                override = false
//            }
//        }
//    }
//    else
//    {
//        override = false
//    }

    if (settingsLoaded) {
        curWep = me.weapon()
        if (curWep.rifle || curWep.smg || curWep.pistol || curWep.sniper || curWep.shotgun) {
            val curWepSettings = convStrToArray(curSettings[curWep.name].toString())

            if (curWepSettings[0]!!.toBool()) {
                curSettings["FACTOR_RECOIL"] = curWepSettings[1]!!.toBool()
                curSettings["ENABLE_FLAT_AIM"] = curWepSettings[2]!!.toBool()
                curSettings["ENABLE_PATH_AIM"] = curWepSettings[3]!!.toBool()
                curSettings["AIM_BONE"] = curWepSettings[4]!!.toInt()
                curSettings["AIM_FOV"] = curWepSettings[5]!!.toInt()
                curSettings["AIM_SPEED"] = curWepSettings[6]!!.toInt()
                curSettings["AIM_SMOOTHNESS"] = curWepSettings[7]
                curSettings["AIM_STRICTNESS"] = curWepSettings[8]
                curSettings["PERFECT_AIM"] = curWepSettings[9]!!.toBool()
                curSettings["PERFECT_AIM_FOV"] = curWepSettings[10]!!.toInt()
                curSettings["PERFECT_AIM_CHANCE"] = curWepSettings[11]!!.toInt()
                override = true
            }
            else { override = false }
        }
    } else { override = false }


    if (!override) {
        if (me.weapon().rifle) {
            curSettings["FACTOR_RECOIL"] = curSettings["RIFLE_FACTOR_RECOIL"]!!.strToBool()
            curSettings["AIM_BONE"] = curSettings["RIFLE_AIM_BONE"].toString().toInt()
            curSettings["AIM_FOV"] = curSettings["RIFLE_AIM_FOV"].toString().toInt()
            curSettings["AIM_SPEED"] = curSettings["RIFLE_AIM_SPEED"].toString().toInt()
            curSettings["AIM_SMOOTHNESS"] = curSettings["RIFLE_AIM_SMOOTHNESS"].toString().toDouble()
            curSettings["AIM_STRICTNESS"] = curSettings["RIFLE_AIM_STRICTNESS"].toString().toDouble()
            curSettings["PERFECT_AIM"] = curSettings["RIFLE_PERFECT_AIM"]!!.strToBool()
            curSettings["PERFECT_AIM_FOV"] = curSettings["RIFLE_PERFECT_AIM_FOV"].toString().toInt()
            curSettings["PERFECT_AIM_CHANCE"] = curSettings["RIFLE_PERFECT_AIM_CHANCE"].toString().toInt()
            curSettings["ENABLE_FLAT_AIM"] = curSettings["RIFLE_ENABLE_FLAT_AIM"]!!.strToBool()
            curSettings["ENABLE_PATH_AIM"] = curSettings["RIFLE_ENABLE_PATH_AIM"]!!.strToBool()
        } else if (me.weapon().smg) {
            curSettings["FACTOR_RECOIL"] = curSettings["SMG_FACTOR_RECOIL"]!!.strToBool()
            curSettings["AIM_BONE"] = curSettings["SMG_AIM_BONE"].toString().toInt()
            curSettings["AIM_FOV"] = curSettings["SMG_AIM_FOV"].toString().toInt()
            curSettings["AIM_SPEED"] = curSettings["SMG_AIM_SPEED"].toString().toInt()
            curSettings["AIM_SMOOTHNESS"] = curSettings["SMG_AIM_SMOOTHNESS"].toString().toDouble()
            curSettings["AIM_STRICTNESS"] = curSettings["SMG_AIM_STRICTNESS"].toString().toDouble()
            curSettings["PERFECT_AIM"] = curSettings["SMG_PERFECT_AIM"]!!.strToBool()
            curSettings["PERFECT_AIM_FOV"] = curSettings["SMG_PERFECT_AIM_FOV"].toString().toInt()
            curSettings["PERFECT_AIM_CHANCE"] = curSettings["SMG_PERFECT_AIM_CHANCE"].toString().toInt()
            curSettings["ENABLE_FLAT_AIM"] = curSettings["SMG_ENABLE_FLAT_AIM"]!!.strToBool()
            curSettings["ENABLE_PATH_AIM"] = curSettings["SMG_ENABLE_PATH_AIM"]!!.strToBool()
        } else if (me.weapon().pistol) {
            curSettings["FACTOR_RECOIL"] = curSettings["PISTOL_FACTOR_RECOIL"]!!.strToBool()
            curSettings["AIM_BONE"] = curSettings["PISTOL_AIM_BONE"].toString().toInt()
            curSettings["AIM_FOV"] = curSettings["PISTOL_AIM_FOV"].toString().toInt()
            curSettings["AIM_SPEED"] = curSettings["PISTOL_AIM_SPEED"].toString().toInt()
            curSettings["AIM_SMOOTHNESS"] = curSettings["PISTOL_AIM_SMOOTHNESS"].toString().toDouble()
            curSettings["AIM_STRICTNESS"] = curSettings["PISTOL_AIM_STRICTNESS"].toString().toDouble()
            curSettings["PERFECT_AIM"] = curSettings["PISTOL_PERFECT_AIM"]!!.strToBool()
            curSettings["PERFECT_AIM_FOV"] = curSettings["PISTOL_PERFECT_AIM_FOV"].toString().toInt()
            curSettings["PERFECT_AIM_CHANCE"] = curSettings["PISTOL_PERFECT_AIM_CHANCE"].toString().toInt()
            curSettings["ENABLE_FLAT_AIM"] = curSettings["PISTOL_ENABLE_FLAT_AIM"]!!.strToBool()
            curSettings["ENABLE_PATH_AIM"] = curSettings["PISTOL_ENABLE_PATH_AIM"]!!.strToBool()
        } else if (me.weapon().sniper) {
            curSettings["FACTOR_RECOIL"] = curSettings["SNIPER_FACTOR_RECOIL"]!!.strToBool()
            curSettings["AIM_BONE"] = curSettings["SNIPER_AIM_BONE"].toString().toInt()
            curSettings["AIM_FOV"] = curSettings["SNIPER_AIM_FOV"].toString().toInt()
            curSettings["AIM_SPEED"] = curSettings["SNIPER_AIM_SPEED"].toString().toInt()
            curSettings["AIM_SMOOTHNESS"] = curSettings["SNIPER_AIM_SMOOTHNESS"].toString().toDouble()
            curSettings["AIM_STRICTNESS"] = curSettings["SNIPER_AIM_STRICTNESS"].toString().toDouble()
            curSettings["PERFECT_AIM"] = curSettings["SNIPER_PERFECT_AIM"]!!.strToBool()
            curSettings["PERFECT_AIM_FOV"] = curSettings["SNIPER_PERFECT_AIM_FOV"].toString().toInt()
            curSettings["PERFECT_AIM_CHANCE"] = curSettings["SNIPER_PERFECT_AIM_CHANCE"].toString().toInt()
            curSettings["ENABLE_FLAT_AIM"] = curSettings["SNIPER_ENABLE_FLAT_AIM"]!!.strToBool()
            curSettings["ENABLE_PATH_AIM"] = curSettings["SNIPER_ENABLE_PATH_AIM"]!!.strToBool()
        } else if (me.weapon().shotgun) {
            curSettings["FACTOR_RECOIL"] = curSettings["SHOTGUN_FACTOR_RECOIL"]!!.strToBool()
            curSettings["AIM_BONE"] = curSettings["SHOTGUN_AIM_BONE"].toString().toInt()
            curSettings["AIM_FOV"] = curSettings["SHOTGUN_AIM_FOV"].toString().toInt()
            curSettings["AIM_SPEED"] = curSettings["SHOTGUN_AIM_SPEED"].toString().toInt()
            curSettings["AIM_SMOOTHNESS"] = curSettings["SHOTGUN_AIM_SMOOTHNESS"].toString().toDouble()
            curSettings["AIM_STRICTNESS"] = curSettings["SHOTGUN_AIM_STRICTNESS"].toString().toDouble()
            curSettings["PERFECT_AIM"] = curSettings["SHOTGUN_PERFECT_AIM"]!!.strToBool()
            curSettings["PERFECT_AIM_FOV"] = curSettings["SHOTGUN_PERFECT_AIM_FOV"].toString().toInt()
            curSettings["PERFECT_AIM_CHANCE"] = curSettings["SHOTGUN_PERFECT_AIM_CHANCE"].toString().toInt()
            curSettings["ENABLE_FLAT_AIM"] = curSettings["SHOTGUN_ENABLE_FLAT_AIM"]!!.strToBool()
            curSettings["ENABLE_PATH_AIM"] = curSettings["SHOTGUN_ENABLE_PATH_AIM"]!!.strToBool()
        }
    }
}

fun Double.toBool() = this == 1.0