package com.example.a11ycodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun Item(title: String) {
    var favorited by remember { mutableStateOf(false) }
    val rowActionLabel = "Oepn Pdp"
    val iconActionLabel = if (favorited) "UnFavorite" else "Favorite"
    Row(
        Modifier
            .fillMaxWidth()
            .clickable(onClickLabel = rowActionLabel) {
                // Open PDP
            }
            .semantics {
                customActions = listOf(
                    CustomAccessibilityAction(
                        label = iconActionLabel,
                        action = {
                            favorited = !favorited
                            true
                        }
                    )
                )
            }
            .padding(36.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.weight(1f)) {
            Text(text = title)
        }
        Icon(
            imageVector = if (favorited) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = "Favorite PDP",
            modifier = Modifier
                .size(24.dp)
                .clickable(onClickLabel = iconActionLabel) {
                    favorited = !favorited
                }
                .clearAndSetSemantics { }
        )
    }
}

@Preview
@Composable
fun CustomActions() {
    LazyColumn {
        items(10) {
            Item("Listing title $it")
            Box(Modifier.height(1.dp).fillMaxWidth().background(Color.Gray))
        }
    }
}