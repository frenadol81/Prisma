package com.example.shared.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrismaButton(
  text: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  isLoading: Boolean = false,
  testTag: String? = null,
) {
  val baseModifier = if (testTag != null) modifier.testTag(testTag) else modifier

  Button(
    onClick = { if (!isLoading) onClick() },
    enabled = enabled && !isLoading,
    colors = ButtonDefaults.buttonColors(
      containerColor = MaterialTheme.colorScheme.primary,
      contentColor = MaterialTheme.colorScheme.onPrimary,
      disabledContainerColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.12f),
      disabledContentColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.38f)
    ),
    shape = MaterialTheme.shapes.medium,
    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
    modifier = baseModifier
      .fillMaxWidth()
      .heightIn(min = 48.dp) // Minimum touch target size
  ) {
    Box(contentAlignment = Alignment.Center) {
      if (isLoading) {
        CircularProgressIndicator(
          modifier = Modifier.size(20.dp),
          color = MaterialTheme.colorScheme.onPrimary,
          strokeWidth = 2.dp
        )
      } else {
        Text(
          text = text,
          style = MaterialTheme.typography.labelLarge.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            letterSpacing = 0.5.sp
          )
        )
      }
    }
  }
}
