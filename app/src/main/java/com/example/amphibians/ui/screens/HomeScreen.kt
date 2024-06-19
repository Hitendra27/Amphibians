package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibians.R
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun HomeScreen(
    ambhibiansUiState: String,
    modifier: Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    ) {
    when (ambhibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is AmphibiansUiState.Success -> ResultScreen(
            photos = ambhibiansUiState,
            modifier = modifier.padding(top = contentPadding.calculateTopPadding())
        )
        is AmphibiansUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

/**
 * LoadingScreen displaying a loading spinner.
 */
@Composable

/**
 * ResultScreen displaying number of photos retrieved.
 */
@Composable
fun ResultScreen(
    photos: String,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(
            text = photos,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun ResultScreenPreview() {
    AmphibiansTheme {
        ResultScreen(stringResource(R.string.placeholder_result), modifier = Modifier)
    }
}