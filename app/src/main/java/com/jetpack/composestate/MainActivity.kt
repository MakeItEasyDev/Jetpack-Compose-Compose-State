package com.jetpack.composestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jetpack.composestate.ui.theme.ComposeStateTheme

class MainActivity : ComponentActivity() {
    private val viewModel: ComposeStateViewModel by viewModels()
    private var state by mutableStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStateTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Compose State",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            ComposeState(viewModel)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ComposeState(viewModel: ComposeStateViewModel) {
        var rememberState by remember { mutableStateOf(0) }
        var rememberSaveableState by rememberSaveable { mutableStateOf(0) }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { state++ }
            ) {
                Text(text = "Click Me!")
            }
            Text(
                text = "Compose State: $state",
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { rememberState++ }
            ) {
                Text(text = "Click Me!")
            }
            Text(
                text = "Remember Compose State: $rememberState",
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { rememberSaveableState++ }
            ) {
                Text(text = "Click Me!")
            }
            Text(
                text = "RememberSaveable Compose State: $rememberSaveableState",
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { viewModel.triggerComposeState() }
            ) {
                Text(text = "Click Me!")
            }
            Text(
                text = "ViewModel Compose State: ${viewModel.mutableComposeState}",
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { viewModel.triggerSaveableComposeState() }
            ) {
                Text(text = "Click Me!")
            }
            Text(
                text = "ViewModel Saveable Compose State: ${viewModel.saveableMutableComposeState}",
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

























