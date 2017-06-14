require 'calabash-android/calabash_steps'

Then /^I see the twitter button$/ do 
  element_exists("* id:'login_twitter_button'")
end

Then /^I see the facebook button$/ do 
  element_exists("* id:'login_facebook_button'")
end

Then /^I press the facebook button$/ do
  tap_when_element_exists("* id:'login_facebook_button'")
end

Then /^I see facebook's web view$/ do
  wait_for_elements_exist("com.facebook.internal.WebDialog$3", :timeout => 10)
end

Then /^I see facebook's email field$/ do
  wait_for_elements_exist("com.facebook.internal.WebDialog$3 css:'input[name=\"email\"]'", :timeout => 10)
end

Then /^I see facebook's password field$/ do
  wait_for_elements_exist("com.facebook.internal.WebDialog$3 css:'input[name=\"pass\"]'", :timeout => 10)
end

Then /^I see facebook's login button$/ do
  wait_for_elements_exist("com.facebook.internal.WebDialog$3 css:'button[name=\"login\"]'", :timeout => 10)
end

