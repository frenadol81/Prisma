package com.example.shared.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrismaAppBar(
  title: String,
  modifier: Modifier = Modifier,
  onNavigateBack: (() -> Unit)? = null,
  testTag: String? = null,
  actions: @Composable () -> Unit = {}
) {
  val baseModifier = if (testTag != null) modifier.testTag(testTag) else modifier

  TopAppBar(
    title = {
      Text(
        text = title,
        style = MaterialTheme.typography.titleLarge.copy(
          fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.onBackground
      )
    },
    navigationIcon = {
      if (onNavigateBack != null) {
        IconButton(
          onClick = onNavigateBack,
          modifier = Modifier
            .testTag(if (testTag != null) "${testTag}_back" else "btn_back")
        ) {
          Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = "Volver",
            tint = MaterialTheme.colorScheme.onBackground
          )
        }
      }
    },
    actions = { actions() },
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = Color.Transparent,
      scrolledContainerColor = Color.Transparent,
      titleContentColor = MaterialTheme.colorScheme.onBackground,
      navigationIconContentColor = MaterialTheme.colorScheme.onBackground
    ),
    modifier = baseModifier
  )
}
