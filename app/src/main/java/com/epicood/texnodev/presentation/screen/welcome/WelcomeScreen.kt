package com.epicood.texnodev.presentation.screen.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.epicood.texnodev.R
import com.epicood.texnodev.domain.model.OnBoardingPage
import com.epicood.texnodev.navigation.Screen
import com.epicood.texnodev.ui.theme.*
import com.epicood.texnodev.util.Constants.ON_BOARDING_PAGE_COUNT
import com.google.accompanist.pager.*

@ExperimentalPagerApi
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel(),
){
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )

    val pagerState = rememberPagerState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.welcomeScreenBackgroundColor)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            count = ON_BOARDING_PAGE_COUNT,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.activateIndicatorColor,
            inactiveColor = MaterialTheme.colors.inActivateIndicatorColor,
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING
        )
        FinishButton(
            modifier = Modifier.weight(1f),
            pageState = pagerState
        ) {
            navController.popBackStack()
            navController.navigate(Screen.Home.rout)
            welcomeViewModel.saveOnBoardingState(completed = true)
        }
    }
}

@ExperimentalPagerApi
@Composable
fun FinishButton(
    modifier: Modifier,
    pageState: PagerState,
    onClick: () -> Unit
){
    Row(
        modifier = modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pageState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.bottomBackgroundColor,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Finish",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,)
            }
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(R.string.on_boarding_image)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SMALE_PADDING),
            text = onBoardingPage.title,
            color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALE_PADDING),
            text = onBoardingPage.description,
            color = MaterialTheme.colors.descriptionColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun SecondOnBoardingPreview(){
    Column(modifier = Modifier.fillMaxWidth()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Second)
    }
}

@Composable
@Preview
fun FirstOnBoardingPreview(){
    Column(modifier = Modifier.fillMaxWidth()) {
        PagerScreen(onBoardingPage = OnBoardingPage.First)
    }
}

@Composable
@Preview
fun ThirdOnBoardingPreview(){
    Column(modifier = Modifier.fillMaxWidth()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Third)
    }
}