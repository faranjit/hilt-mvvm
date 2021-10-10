package com.faranjit.hilt.mvvm.dialog

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
data class DialogModel(
    var title: String? = null,
    var message: String? = null,
    var positiveButton: DialogButton? = null
)

data class DialogButton(
    var text: String? = null,
    var task: (() -> Unit)? = null
)

object DialogModelBuilder {
    private var dialogModel = DialogModel()

    fun title(title: String) {
        dialogModel.title = title
    }

    fun message(message: String) {
        dialogModel.message = message
    }

    fun button(text: String, task: (() -> Unit)? = null) {
        dialogModel.positiveButton = DialogButton(text, task)
    }

    fun build() = dialogModel
}

fun dialog(builder: DialogModelBuilder.() -> Unit): DialogModel {
    return DialogModelBuilder.apply(builder).build()
}