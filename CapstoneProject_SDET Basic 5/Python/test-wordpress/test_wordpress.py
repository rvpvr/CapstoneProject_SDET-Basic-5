import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


@pytest.fixture(scope="module")
def setup():
    # Setup WebDriver
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    # Teardown WebDriver
    driver.quit()


def test_verify_title(setup):
    driver = setup
    driver.get("https://wordpress.org/")
    assert "WordPress.org" in driver.title


def test_hover_and_click(setup):
    driver = setup
    driver.get("https://wordpress.org/")

    # Perform mouseover action on 'Download & Extend' and click on 'Themes' option
    download_extend = driver.find_element(By.XPATH, "//a[text()='Download & Extend']")
    themes = driver.find_element(By.XPATH, "//a[text()='Themes']")

    action = ActionChains(driver)
    action.move_to_element(download_extend).move_to_element(themes).click().perform()

    WebDriverWait(driver, 10).until(EC.title_contains("Themes"))
    assert "Themes" in driver.title


def test_search_theme(setup):
    driver = setup
    driver.get("https://wordpress.org/")

    # Perform mouseover action on 'Download & Extend' and click on 'Themes' option
    download_extend = driver.find_element(By.XPATH, "//a[text()='Download & Extend']")
    themes = driver.find_element(By.XPATH, "//a[text()='Themes']")

    action = ActionChains(driver)
    action.move_to_element(download_extend).move_to_element(themes).click().perform()

    # Search for theme and verify themes are displayed with titles
    search_input = driver.find_element(By.ID, "themes-search")
    search_input.send_keys("Twenty Twenty-One")  # Example theme name
    search_input.submit()

    theme_results = driver.find_elements(By.CLASS_NAME, "theme")
    assert len(theme_results) > 0
