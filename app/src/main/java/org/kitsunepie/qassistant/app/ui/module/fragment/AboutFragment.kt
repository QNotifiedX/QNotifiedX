package org.kitsunepie.qassistant.app.ui.module.fragment

import org.kitsunepie.maitungtmui.base.*
import org.kitsunepie.qassistant.R
import org.kitsunepie.qassistant.app.ui.module.activity.safeResources
import org.kitsunepie.qassistant.app.util.Utils.openUrl

val aboutFragment: UiScreen = uiScreen {
    name = safeResources.getString(R.string.module_more_setting_about)
    summary = null
    contains = linkedMapOf(
        uiCategory {
            noTitle = true
            contains = linkedMapOf(
                uiClickableItem {
                    title = safeResources.getString(R.string.module_more_setting_about_agreement)
                },
                uiClickableItem {
                    title = safeResources.getString(R.string.module_more_setting_about_privacy)
                }
            )
        },
        uiCategory {
            noTitle = true
            contains = linkedMapOf(
                uiClickableItem {
                    title = safeResources.getString(R.string.module_more_setting_about_check_update)
                }
            )
        },
        uiCategory {
            noTitle = true
            contains = linkedMapOf(
                uiClickableItem {
                    title =
                        safeResources.getString(R.string.module_more_setting_about_telegram_channel)
                    onClickListener = {
                        it.openUrl("https://t.me/QAssistant")
                        true
                    }
                }
            )
        },
        uiCategory {
            noTitle = true
            contains = linkedMapOf(
                uiClickableItem {
                    title =
                        safeResources.getString(R.string.module_more_setting_about_main_devs)
                    onClickListener = ClickToNewSetting(devsFragment)
                }
            )
        },
        uiCategory {
            noTitle = true
            contains = linkedMapOf(
                uiClickableItem {
                    title = safeResources.getString(R.string.module_more_setting_about_github)
                    onClickListener = {
                        it.openUrl("https://github.com/KitsunePie/QAssistant")
                        true
                    }
                },
                uiClickableItem {
                    title =
                        safeResources.getString(R.string.module_more_setting_about_open_sources_license)
                }
            )
        }
    )
}.second