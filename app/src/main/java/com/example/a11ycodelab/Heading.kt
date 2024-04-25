package com.example.a11ycodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .semantics {
                heading()
            },
        fontSize = 24.sp
    )
}

@Composable
fun Content(text: String) {
    Text(
        text = text,
        fontSize = 16.sp
    )
}

@Preview
@Composable
fun Heading() {
    Column(modifier = Modifier.padding(24.dp)) {
        Header("Section 1")
        Content("This is the content for section 1.".repeat(5))
        Header("Section 2")
        Content("This is the content for section 2.".repeat(5))
        Header("Section 3")
        Content("This is the content for section 3.".repeat(5))
    }
}




