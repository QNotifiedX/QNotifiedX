/*
 * QAssistant - An Xposed module for QQ/TIM
 * Copyright (C) 2019-2021
 * https://github.com/KitsunePie/QAssistant
 *
 * This software is non-free but opensource software: you can redistribute it
 * and/or modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation and our eula published by us;
 *  either version 3 of the License, or any later version and our eula as published
 * by us.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * and eula along with this software.  If not, see
 * <https://www.gnu.org/licenses/>
 * <https://github.com/KitsunePie/QAssistant/blob/master/LICENSE.md>.
 */

package org.kitsunepie.qassistant.app.hook.normal.simplify

import android.view.View
import com.github.kyuubiran.ezxhelper.utils.findMethod
import com.github.kyuubiran.ezxhelper.utils.hookReplace
import com.github.kyuubiran.ezxhelper.utils.isStatic
import com.github.kyuubiran.ezxhelper.utils.loadClass
import org.kitsunepie.qassistant.R
import org.kitsunepie.qassistant.annotations.NormalHookEntry
import org.kitsunepie.qassistant.app.hook.base.BaseHook
import org.kitsunepie.qassistant.app.hook.base.IHookInfo
import org.kitsunepie.qassistant.app.util.ClassPointer
import org.kitsunepie.qassistant.app.util.clazz

@NormalHookEntry
object DefaultFont : BaseHook(), IHookInfo {
    override fun init() {
        ClassPointer.TextItemBuilder.clazz?.let {
            findMethod(it) {
                name == "a" && !isStatic &&
                    returnType == Void.TYPE &&
                    parameterTypes.contentDeepEquals(
                        arrayOf(
                            View::class.java,
                            loadClass("com.tencent.mobileqq.data.ChatMessage")
                        )
                    )
            }.also { m ->
                m.hookReplace { null }
            }
        }
    }

    override val titleRes: Int
        get() = R.string.module_function_setting_purify_chat_default_font

    override val descRes: Int
        get() = R.string.module_function_setting_purify_chat_default_font_desc
}
