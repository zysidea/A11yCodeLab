package com.example.a11ycodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
private fun Item(
    title: String,
    parentModifier: Modifier = Modifier,
    childModifier: Modifier = Modifier
) {
    Column {
        Text(title, fontSize = 24.sp)
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = parentModifier
                .fillMaxWidth()
                .background(Color.Red)
        ) {
            Text("One", fontSize = 24.sp)
            Column(modifier = childModifier) {
                Text("Two", fontSize = 24.sp)
                Text("Three", fontSize = 24.sp)
            }
        }
    }
}

@Preview
@Composable
fun Merge() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Item(
            title = "Reads [One -> Two -> Three]",
        )

        Item(
            title = "Reads [One Two Three]",
            parentModifier = Modifier.semantics(mergeDescendants = true) { }
        )

        Item(
            title = "Reads [One -> Two Three]",
            childModifier = Modifier.semantics(mergeDescendants = true) { }
        )

        Item(
            title = "Reads [Custom Description One Two Three]",
            parentModifier = Modifier.semantics(mergeDescendants = true) {
                contentDescription = "Custom Description"
            }
        )

        Item(
            title = "Reads [Custom Description]",
            parentModifier = Modifier.clearAndSetSemantics {
                contentDescription = "Custom Description"
            }
        )
    }
}
