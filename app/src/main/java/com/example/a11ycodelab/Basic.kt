package com.example.a11ycodelab

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a11ycodelab.component.Block
import com.example.a11ycodelab.component.SubBlock

@Preview
@Composable
fun Basic() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Block("Visual element description") {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Share PDP",
                modifier = Modifier
                    .clickable {
                        // Handle click
                    }
                    .border(1.dp, Color.Gray)
                    .padding(12.dp)
                    .size(24.dp)
                    .border(1.dp, Color.Gray.copy(alpha = 0.5f))
            )
        }

        Block(title = "Click label") {
            Row(
                Modifier
                    .clickable(onClickLabel = "Open PDP") {
                        // Handle click
                    }
                    .border(1.dp, Color.Gray)
                    .padding(24.dp)
                    .fillMaxWidth(),

                ) {
                Text("Listing title")
            }
//            Row(
//                Modifier.semantics {
//                    onClick(
//                        label = "Open Pdp",
//                        action = {
//                            // Handle click
//                            true
//                        }
//                    )
//                }
//                .border(1.dp, Color.Gray)
//                    .padding(24.dp)
//                    .fillMaxWidth(),
//
//            ) {
//                Text("Listing title")
//            }
        }

        Block(title = "Custom section control") {
            SubBlock(title = "Lift the clickable behavior to the parent container") {
                var checked by remember { mutableStateOf(false) }
                Row(
                    Modifier
                        .border(1.dp, Color.Gray)
                        .toggleable(
                            value = checked,
                            role = Role.Checkbox,
                            onValueChange = { checked = !checked }
                        )
                        .padding(24.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(Modifier.weight(1f)) {
                        Text(text = "Option")
                    }
                    Checkbox(
                        checked = checked,
                        onCheckedChange = null
                    )
                }
            }
        }

        Block("State description") {
            var checked by remember { mutableStateOf(false) }
            Row(
                Modifier
                    .border(1.dp, Color.Gray)
                    .semantics {
                        stateDescription = if (checked) {
                            "Wishlist saved"
                        } else {
                            "WishList unsaved"
                        }
                    }
                    .toggleable(
                        value = checked,
                        role = Role.Checkbox,
                        onValueChange = { checked = !checked }
                    )
                    .padding(24.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(Modifier.weight(1f)) {
                    Text(text = "Listing title")
                }
                Checkbox(
                    checked = checked,
                    onCheckedChange = null
                )
            }
        }
    }
}