package com.github.nidroid.uiperfectcopycontesttest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.nidroid.uiperfectcopycontesttest.ui.theme.UIPerfectCopyContestTestTheme

@Composable
internal fun YourAnswer() {
    var name by remember { mutableStateOf("") }
    Card {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = "example form",
                style = MaterialTheme.typography.headlineLarge,
            )
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("your name") },
                modifier = Modifier.fillMaxWidth(),
            )

            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
                Text("OK")
            }
        }
    }
}

@Preview
@Composable
private fun YourAnswerPreview() {
    UIPerfectCopyContestTestTheme {
        YourAnswer()
    }
}
