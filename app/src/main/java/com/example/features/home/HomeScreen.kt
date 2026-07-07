package com.example.features.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material.icons.rounded.Assignment
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.People
import androidx.compose.material.icons.rounded.PlayCircleOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.shared.components.PrismaAppBar
import com.example.shared.components.PrismaCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
  onNavigateToContinueSession: () -> Unit,
  onNavigateToNewSession: () -> Unit,
  onNavigateToStudents: () -> Unit,
  onNavigateToActivities: () -> Unit,
) {
  var visible by remember { mutableStateOf(false) }
  LaunchedEffect(Unit) {
    visible = true
  }

  Scaffold(
    topBar = {
      PrismaAppBar(
        title = stringResource(R.string.app_name),
        testTag = "home_top_bar",
        actions = {
          Box(
            modifier = Modifier
              .padding(end = 16.dp)
              .size(36.dp)
              .clip(CircleShape)
              .background(
                Brush.linearGradient(
                  colors = listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
                  )
                )
              ),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = Icons.Rounded.AutoAwesome,
              contentDescription = null,
              tint = Color.White,
              modifier = Modifier.size(18.dp)
            )
          }
        }
      )
    },
    containerColor = MaterialTheme.colorScheme.background
  ) { innerPadding ->
    AnimatedVisibility(
      visible = visible,
      enter = fadeIn() + slideInVertically(initialOffsetY = { 40 })
    ) {
      BoxWithConstraints(
        modifier = Modifier
          .fillMaxSize()
          .padding(innerPadding)
          .padding(horizontal = 24.dp)
      ) {
        val width = maxWidth
        val isWide = width > 600.dp

        Column(
          modifier = Modifier.fillMaxSize(),
          verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
          // Hero Header / Subtitle
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 12.dp)
          ) {
            Text(
              text = "Asistente Pedagógico",
              style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = (-0.5).sp
              ),
              color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "Simplifica el aula, recoge evidencias de aprendizaje y toma decisiones pedagógicas basadas en datos. La IA únicamente propone, tú decides.",
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
              lineHeight = 20.sp
            )
          }

          Spacer(modifier = Modifier.height(8.dp))

          // 2x2 Grid or single column list depending on width
          val columns = if (isWide) GridCells.Fixed(2) else GridCells.Fixed(1)

          LazyVerticalGrid(
            columns = columns,
            modifier = Modifier
              .fillMaxWidth()
              .weight(1f),
            contentPadding = PaddingValues(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
          ) {
            item {
              HomeActionCard(
                title = "Continuar sesión",
                description = "Retoma el registro de evidencias de la última sesión activa.",
                icon = Icons.Rounded.PlayCircleOutline,
                accentColor = MaterialTheme.colorScheme.primary,
                testTag = "btn_continue_session",
                onClick = onNavigateToContinueSession
              )
            }
            item {
              HomeActionCard(
                title = "Nueva sesión",
                description = "Comienza una sesión de aprendizaje para capturar nuevas evidencias.",
                icon = Icons.Rounded.AddCircleOutline,
                accentColor = MaterialTheme.colorScheme.primary,
                testTag = "btn_new_session",
                onClick = onNavigateToNewSession
              )
            }
            item {
              HomeActionCard(
                title = "Alumnado",
                description = "Gestión de grupos y alta rápida de alumnos con pegado de listas.",
                icon = Icons.Rounded.People,
                accentColor = MaterialTheme.colorScheme.primary,
                testTag = "btn_students",
                onClick = onNavigateToStudents
              )
            }
            item {
              HomeActionCard(
                title = "Actividades",
                description = "Crea y organiza las actividades evaluables asignadas a tus sesiones.",
                icon = Icons.Rounded.Assignment,
                accentColor = MaterialTheme.colorScheme.primary,
                testTag = "btn_activities",
                onClick = onNavigateToActivities
              )
            }
          }

          // Footer info status
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(bottom = 16.dp)
              .clip(MaterialTheme.shapes.medium)
              .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))
              .padding(16.dp),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = "PRISMA • Control docente absoluto • IA de apoyo",
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f),
              fontWeight = FontWeight.Medium
            )
          }
        }
      }
    }
  }
}

@Composable
fun HomeActionCard(
  title: String,
  description: String,
  icon: ImageVector,
  accentColor: Color,
  testTag: String,
  onClick: () -> Unit,
) {
  PrismaCard(
    onClick = onClick,
    testTag = testTag
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(56.dp)
          .clip(MaterialTheme.shapes.medium)
          .background(accentColor.copy(alpha = 0.08f)),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = icon,
          contentDescription = null,
          tint = accentColor,
          modifier = Modifier.size(28.dp)
        )
      }
      Spacer(modifier = Modifier.width(16.dp))
      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          text = title,
          style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold,
            letterSpacing = (-0.2).sp
          ),
          color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = description,
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          maxLines = 2,
          lineHeight = 15.sp
        )
      }
    }
  }
}
