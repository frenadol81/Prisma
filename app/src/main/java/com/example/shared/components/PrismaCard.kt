package com.example.shared.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.shared.theme.PrismaBorder

@Composable
fun PrismaCard(
  modifier: Modifier = Modifier,
  onClick: (() -> Unit)? = null,
  testTag: String? = null,
  content: @Composable () -> Unit
) {
  val baseModifier = if (testTag != null) modifier.testTag(testTag) else modifier
  val cardModifier = if (onClick != null) baseModifier.clickable(onClick = onClick) else baseModifier

  Card(
    modifier = cardModifier.fillMaxWidth(),
    shape = MaterialTheme.shapes.large,
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.surface,
      contentColor = MaterialTheme.colorScheme.onSurface
    ),
    border = BorderStroke(
      width = 1.dp,
      color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.08f)
    ),
    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
  ) {
    Box(modifier = Modifier.padding(20.dp)) {
      content()
    }
  }
}
