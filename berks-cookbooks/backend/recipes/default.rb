
# Cookbook Name:: kk-
# Recipe:: default
#
# Copyright (C) 2017 
#
    s3_file "/home/ec2-user/BackEnd.jar" do
        remote_path "BackEnd.jar"
        bucket "backendbucket1"
        s3_url "https://s3-eu-west-1.amazonaws.com/backendbucket1"
        action :create
    end


execute "running BackEnd.jar" do
  command "java -jar /home/ec2-user/BackEnd.jar "
  cwd "/home/ec2-user"
  action "run"
end