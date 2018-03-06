package com.example.alison.appgithubapi.pull.mock

interface MockListPulls {
    companion object {
        const val sucessResponse: String = "[\n" +
                "    {\n" +
                "        \"url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28909\",\n" +
                "        \"id\": 173113181,\n" +
                "        \"html_url\": \"https://github.com/elastic/elasticsearch/pull/28909\",\n" +
                "        \"diff_url\": \"https://github.com/elastic/elasticsearch/pull/28909.diff\",\n" +
                "        \"patch_url\": \"https://github.com/elastic/elasticsearch/pull/28909.patch\",\n" +
                "        \"issue_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/28909\",\n" +
                "        \"number\": 28909,\n" +
                "        \"state\": \"open\",\n" +
                "        \"locked\": false,\n" +
                "        \"title\": \"Send REST response for incorrectly encoded url params\",\n" +
                "        \"user\": {\n" +
                "            \"login\": \"olcbean\",\n" +
                "            \"id\": 26058559,\n" +
                "            \"avatar_url\": \"https://avatars3.githubusercontent.com/u/26058559?v=4\",\n" +
                "            \"gravatar_id\": \"\",\n" +
                "            \"url\": \"https://api.github.com/users/olcbean\",\n" +
                "            \"html_url\": \"https://github.com/olcbean\",\n" +
                "            \"followers_url\": \"https://api.github.com/users/olcbean/followers\",\n" +
                "            \"following_url\": \"https://api.github.com/users/olcbean/following{/other_user}\",\n" +
                "            \"gists_url\": \"https://api.github.com/users/olcbean/gists{/gist_id}\",\n" +
                "            \"starred_url\": \"https://api.github.com/users/olcbean/starred{/owner}{/repo}\",\n" +
                "            \"subscriptions_url\": \"https://api.github.com/users/olcbean/subscriptions\",\n" +
                "            \"organizations_url\": \"https://api.github.com/users/olcbean/orgs\",\n" +
                "            \"repos_url\": \"https://api.github.com/users/olcbean/repos\",\n" +
                "            \"events_url\": \"https://api.github.com/users/olcbean/events{/privacy}\",\n" +
                "            \"received_events_url\": \"https://api.github.com/users/olcbean/received_events\",\n" +
                "            \"type\": \"User\",\n" +
                "            \"site_admin\": false\n" +
                "        },\n" +
                "        \"body\": \"Previously if the `path` contained incorrectly encoded sequence, an error was returned : \\r\\n```\\r\\ncurl -XGET http://localhost:9200/index%?pretty\\r\\n```\\r\\n```\\r\\n{\\r\\n  \\\"error\\\" : {\\r\\n    \\\"root_cause\\\" : [\\r\\n      {\\r\\n        \\\"type\\\" : \\\"illegal_argument_exception\\\",\\r\\n        \\\"reason\\\" : \\\"unterminated escape sequence at end of string: index%\\\"\\r\\n      }\\r\\n    ],\\r\\n    \\\"type\\\" : \\\"illegal_argument_exception\\\",\\r\\n    \\\"reason\\\" : \\\"unterminated escape sequence at end of string: index%\\\"\\r\\n  },\\r\\n  \\\"status\\\" : 400\\r\\n}\\r\\n```\\r\\nBut if the incorrect sequence was part of the `parameters`, **no** response was returned.\\r\\n```\\r\\ncurl -XGET http://localhost:9200/index?pretty%\\r\\n```\\r\\n```\\r\\ncurl: (52) Empty reply from server\\r\\n```\\r\\nThis PR analyze the `parameters` and returns an error when there is a wrong encoding sequence in the url params ( The errors are consistent with the ones returned for incorrect `path` )\\r\\n```\\r\\ncurl -XGET http://localhost:9200/index?pretty%\\r\\n```\\r\\n```\\r\\n{\\r\\n  \\\"error\\\": {\\r\\n    \\\"root_cause\\\": [\\r\\n      {\\r\\n        \\\"type\\\": \\\"illegal_argument_exception\\\",\\r\\n        \\\"reason\\\": \\\"unterminated escape sequence at end of string: pretty%\\\"\\r\\n      }\\r\\n    ],\\r\\n    \\\"type\\\": \\\"illegal_argument_exception\\\",\\r\\n    \\\"reason\\\": \\\"unterminated escape sequence at end of string: pretty%\\\"\\r\\n  },\\r\\n  \\\"status\\\": 400\\r\\n}\\r\\n``` \\r\\nFixes : #21974\",\n" +
                "        \"created_at\": \"2018-03-06T10:17:42Z\",\n" +
                "        \"updated_at\": \"2018-03-06T16:41:59Z\",\n" +
                "        \"closed_at\": null,\n" +
                "        \"merged_at\": null,\n" +
                "        \"merge_commit_sha\": \"3140b66e325db1ae7a8b2f6abd07217c2bef8799\",\n" +
                "        \"assignee\": null,\n" +
                "        \"assignees\": [],\n" +
                "        \"requested_reviewers\": [],\n" +
                "        \"requested_teams\": [],\n" +
                "        \"labels\": [\n" +
                "            {\n" +
                "                \"id\": 152517143,\n" +
                "                \"url\": \"https://api.github.com/repos/elastic/elasticsearch/labels/:Core/REST%20API\",\n" +
                "                \"name\": \":Core/REST API\",\n" +
                "                \"color\": \"0e8a16\",\n" +
                "                \"default\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 23174,\n" +
                "                \"url\": \"https://api.github.com/repos/elastic/elasticsearch/labels/%3Eenhancement\",\n" +
                "                \"name\": \">enhancement\",\n" +
                "                \"color\": \"4a4ea8\",\n" +
                "                \"default\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 111624690,\n" +
                "                \"url\": \"https://api.github.com/repos/elastic/elasticsearch/labels/feedback_needed\",\n" +
                "                \"name\": \"feedback_needed\",\n" +
                "                \"color\": \"d4c5f9\",\n" +
                "                \"default\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 94283388,\n" +
                "                \"url\": \"https://api.github.com/repos/elastic/elasticsearch/labels/review\",\n" +
                "                \"name\": \"review\",\n" +
                "                \"color\": \"0052cc\",\n" +
                "                \"default\": false\n" +
                "            }\n" +
                "        ],\n" +
                "        \"milestone\": null,\n" +
                "        \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28909/commits\",\n" +
                "        \"review_comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28909/comments\",\n" +
                "        \"review_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/28909/comments\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/3add454763c49cbbd591c2f265df0485b1edfef3\",\n" +
                "        \"head\": {\n" +
                "            \"label\": \"olcbean:rest_params_escape_seq\",\n" +
                "            \"ref\": \"rest_params_escape_seq\",\n" +
                "            \"sha\": \"3add454763c49cbbd591c2f265df0485b1edfef3\",\n" +
                "            \"user\": {\n" +
                "                \"login\": \"olcbean\",\n" +
                "                \"id\": 26058559,\n" +
                "                \"avatar_url\": \"https://avatars3.githubusercontent.com/u/26058559?v=4\",\n" +
                "                \"gravatar_id\": \"\",\n" +
                "                \"url\": \"https://api.github.com/users/olcbean\",\n" +
                "                \"html_url\": \"https://github.com/olcbean\",\n" +
                "                \"followers_url\": \"https://api.github.com/users/olcbean/followers\",\n" +
                "                \"following_url\": \"https://api.github.com/users/olcbean/following{/other_user}\",\n" +
                "                \"gists_url\": \"https://api.github.com/users/olcbean/gists{/gist_id}\",\n" +
                "                \"starred_url\": \"https://api.github.com/users/olcbean/starred{/owner}{/repo}\",\n" +
                "                \"subscriptions_url\": \"https://api.github.com/users/olcbean/subscriptions\",\n" +
                "                \"organizations_url\": \"https://api.github.com/users/olcbean/orgs\",\n" +
                "                \"repos_url\": \"https://api.github.com/users/olcbean/repos\",\n" +
                "                \"events_url\": \"https://api.github.com/users/olcbean/events{/privacy}\",\n" +
                "                \"received_events_url\": \"https://api.github.com/users/olcbean/received_events\",\n" +
                "                \"type\": \"User\",\n" +
                "                \"site_admin\": false\n" +
                "            },\n" +
                "            \"repo\": {\n" +
                "                \"id\": 86361256,\n" +
                "                \"name\": \"elasticsearch\",\n" +
                "                \"full_name\": \"olcbean/elasticsearch\",\n" +
                "                \"owner\": {\n" +
                "                    \"login\": \"olcbean\",\n" +
                "                    \"id\": 26058559,\n" +
                "                    \"avatar_url\": \"https://avatars3.githubusercontent.com/u/26058559?v=4\",\n" +
                "                    \"gravatar_id\": \"\",\n" +
                "                    \"url\": \"https://api.github.com/users/olcbean\",\n" +
                "                    \"html_url\": \"https://github.com/olcbean\",\n" +
                "                    \"followers_url\": \"https://api.github.com/users/olcbean/followers\",\n" +
                "                    \"following_url\": \"https://api.github.com/users/olcbean/following{/other_user}\",\n" +
                "                    \"gists_url\": \"https://api.github.com/users/olcbean/gists{/gist_id}\",\n" +
                "                    \"starred_url\": \"https://api.github.com/users/olcbean/starred{/owner}{/repo}\",\n" +
                "                    \"subscriptions_url\": \"https://api.github.com/users/olcbean/subscriptions\",\n" +
                "                    \"organizations_url\": \"https://api.github.com/users/olcbean/orgs\",\n" +
                "                    \"repos_url\": \"https://api.github.com/users/olcbean/repos\",\n" +
                "                    \"events_url\": \"https://api.github.com/users/olcbean/events{/privacy}\",\n" +
                "                    \"received_events_url\": \"https://api.github.com/users/olcbean/received_events\",\n" +
                "                    \"type\": \"User\",\n" +
                "                    \"site_admin\": false\n" +
                "                },\n" +
                "                \"private\": false,\n" +
                "                \"html_url\": \"https://github.com/olcbean/elasticsearch\",\n" +
                "                \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "                \"fork\": true,\n" +
                "                \"url\": \"https://api.github.com/repos/olcbean/elasticsearch\",\n" +
                "                \"forks_url\": \"https://api.github.com/repos/olcbean/elasticsearch/forks\",\n" +
                "                \"keys_url\": \"https://api.github.com/repos/olcbean/elasticsearch/keys{/key_id}\",\n" +
                "                \"collaborators_url\": \"https://api.github.com/repos/olcbean/elasticsearch/collaborators{/collaborator}\",\n" +
                "                \"teams_url\": \"https://api.github.com/repos/olcbean/elasticsearch/teams\",\n" +
                "                \"hooks_url\": \"https://api.github.com/repos/olcbean/elasticsearch/hooks\",\n" +
                "                \"issue_events_url\": \"https://api.github.com/repos/olcbean/elasticsearch/issues/events{/number}\",\n" +
                "                \"events_url\": \"https://api.github.com/repos/olcbean/elasticsearch/events\",\n" +
                "                \"assignees_url\": \"https://api.github.com/repos/olcbean/elasticsearch/assignees{/user}\",\n" +
                "                \"branches_url\": \"https://api.github.com/repos/olcbean/elasticsearch/branches{/branch}\",\n" +
                "                \"tags_url\": \"https://api.github.com/repos/olcbean/elasticsearch/tags\",\n" +
                "                \"blobs_url\": \"https://api.github.com/repos/olcbean/elasticsearch/git/blobs{/sha}\",\n" +
                "                \"git_tags_url\": \"https://api.github.com/repos/olcbean/elasticsearch/git/tags{/sha}\",\n" +
                "                \"git_refs_url\": \"https://api.github.com/repos/olcbean/elasticsearch/git/refs{/sha}\",\n" +
                "                \"trees_url\": \"https://api.github.com/repos/olcbean/elasticsearch/git/trees{/sha}\",\n" +
                "                \"statuses_url\": \"https://api.github.com/repos/olcbean/elasticsearch/statuses/{sha}\",\n" +
                "                \"languages_url\": \"https://api.github.com/repos/olcbean/elasticsearch/languages\",\n" +
                "                \"stargazers_url\": \"https://api.github.com/repos/olcbean/elasticsearch/stargazers\",\n" +
                "                \"contributors_url\": \"https://api.github.com/repos/olcbean/elasticsearch/contributors\",\n" +
                "                \"subscribers_url\": \"https://api.github.com/repos/olcbean/elasticsearch/subscribers\",\n" +
                "                \"subscription_url\": \"https://api.github.com/repos/olcbean/elasticsearch/subscription\",\n" +
                "                \"commits_url\": \"https://api.github.com/repos/olcbean/elasticsearch/commits{/sha}\",\n" +
                "                \"git_commits_url\": \"https://api.github.com/repos/olcbean/elasticsearch/git/commits{/sha}\",\n" +
                "                \"comments_url\": \"https://api.github.com/repos/olcbean/elasticsearch/comments{/number}\",\n" +
                "                \"issue_comment_url\": \"https://api.github.com/repos/olcbean/elasticsearch/issues/comments{/number}\",\n" +
                "                \"contents_url\": \"https://api.github.com/repos/olcbean/elasticsearch/contents/{+path}\",\n" +
                "                \"compare_url\": \"https://api.github.com/repos/olcbean/elasticsearch/compare/{base}...{head}\",\n" +
                "                \"merges_url\": \"https://api.github.com/repos/olcbean/elasticsearch/merges\",\n" +
                "                \"archive_url\": \"https://api.github.com/repos/olcbean/elasticsearch/{archive_format}{/ref}\",\n" +
                "                \"downloads_url\": \"https://api.github.com/repos/olcbean/elasticsearch/downloads\",\n" +
                "                \"issues_url\": \"https://api.github.com/repos/olcbean/elasticsearch/issues{/number}\",\n" +
                "                \"pulls_url\": \"https://api.github.com/repos/olcbean/elasticsearch/pulls{/number}\",\n" +
                "                \"milestones_url\": \"https://api.github.com/repos/olcbean/elasticsearch/milestones{/number}\",\n" +
                "                \"notifications_url\": \"https://api.github.com/repos/olcbean/elasticsearch/notifications{?since,all,participating}\",\n" +
                "                \"labels_url\": \"https://api.github.com/repos/olcbean/elasticsearch/labels{/name}\",\n" +
                "                \"releases_url\": \"https://api.github.com/repos/olcbean/elasticsearch/releases{/id}\",\n" +
                "                \"deployments_url\": \"https://api.github.com/repos/olcbean/elasticsearch/deployments\",\n" +
                "                \"created_at\": \"2017-03-27T16:55:23Z\",\n" +
                "                \"updated_at\": \"2017-03-27T16:55:55Z\",\n" +
                "                \"pushed_at\": \"2018-03-06T16:39:24Z\",\n" +
                "                \"git_url\": \"git://github.com/olcbean/elasticsearch.git\",\n" +
                "                \"ssh_url\": \"git@github.com:olcbean/elasticsearch.git\",\n" +
                "                \"clone_url\": \"https://github.com/olcbean/elasticsearch.git\",\n" +
                "                \"svn_url\": \"https://github.com/olcbean/elasticsearch\",\n" +
                "                \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "                \"size\": 374183,\n" +
                "                \"stargazers_count\": 0,\n" +
                "                \"watchers_count\": 0,\n" +
                "                \"language\": \"Java\",\n" +
                "                \"has_issues\": false,\n" +
                "                \"has_projects\": true,\n" +
                "                \"has_downloads\": true,\n" +
                "                \"has_wiki\": false,\n" +
                "                \"has_pages\": false,\n" +
                "                \"forks_count\": 0,\n" +
                "                \"mirror_url\": null,\n" +
                "                \"archived\": false,\n" +
                "                \"open_issues_count\": 0,\n" +
                "                \"license\": null,\n" +
                "                \"forks\": 0,\n" +
                "                \"open_issues\": 0,\n" +
                "                \"watchers\": 0,\n" +
                "                \"default_branch\": \"master\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"base\": {\n" +
                "            \"label\": \"elastic:master\",\n" +
                "            \"ref\": \"master\",\n" +
                "            \"sha\": \"e7d1e12675d72b5b297832b6bb45cbb3fed753d5\",\n" +
                "            \"user\": {\n" +
                "                \"login\": \"elastic\",\n" +
                "                \"id\": 6764390,\n" +
                "                \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "                \"gravatar_id\": \"\",\n" +
                "                \"url\": \"https://api.github.com/users/elastic\",\n" +
                "                \"html_url\": \"https://github.com/elastic\",\n" +
                "                \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "                \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "                \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "                \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "                \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "                \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "                \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "                \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "                \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "                \"type\": \"Organization\",\n" +
                "                \"site_admin\": false\n" +
                "            },\n" +
                "            \"repo\": {\n" +
                "                \"id\": 507775,\n" +
                "                \"name\": \"elasticsearch\",\n" +
                "                \"full_name\": \"elastic/elasticsearch\",\n" +
                "                \"owner\": {\n" +
                "                    \"login\": \"elastic\",\n" +
                "                    \"id\": 6764390,\n" +
                "                    \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "                    \"gravatar_id\": \"\",\n" +
                "                    \"url\": \"https://api.github.com/users/elastic\",\n" +
                "                    \"html_url\": \"https://github.com/elastic\",\n" +
                "                    \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "                    \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "                    \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "                    \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "                    \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "                    \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "                    \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "                    \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "                    \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "                    \"type\": \"Organization\",\n" +
                "                    \"site_admin\": false\n" +
                "                },\n" +
                "                \"private\": false,\n" +
                "                \"html_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "                \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "                \"fork\": false,\n" +
                "                \"url\": \"https://api.github.com/repos/elastic/elasticsearch\",\n" +
                "                \"forks_url\": \"https://api.github.com/repos/elastic/elasticsearch/forks\",\n" +
                "                \"keys_url\": \"https://api.github.com/repos/elastic/elasticsearch/keys{/key_id}\",\n" +
                "                \"collaborators_url\": \"https://api.github.com/repos/elastic/elasticsearch/collaborators{/collaborator}\",\n" +
                "                \"teams_url\": \"https://api.github.com/repos/elastic/elasticsearch/teams\",\n" +
                "                \"hooks_url\": \"https://api.github.com/repos/elastic/elasticsearch/hooks\",\n" +
                "                \"issue_events_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/events{/number}\",\n" +
                "                \"events_url\": \"https://api.github.com/repos/elastic/elasticsearch/events\",\n" +
                "                \"assignees_url\": \"https://api.github.com/repos/elastic/elasticsearch/assignees{/user}\",\n" +
                "                \"branches_url\": \"https://api.github.com/repos/elastic/elasticsearch/branches{/branch}\",\n" +
                "                \"tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/tags\",\n" +
                "                \"blobs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/blobs{/sha}\",\n" +
                "                \"git_tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/tags{/sha}\",\n" +
                "                \"git_refs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/refs{/sha}\",\n" +
                "                \"trees_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/trees{/sha}\",\n" +
                "                \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/{sha}\",\n" +
                "                \"languages_url\": \"https://api.github.com/repos/elastic/elasticsearch/languages\",\n" +
                "                \"stargazers_url\": \"https://api.github.com/repos/elastic/elasticsearch/stargazers\",\n" +
                "                \"contributors_url\": \"https://api.github.com/repos/elastic/elasticsearch/contributors\",\n" +
                "                \"subscribers_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscribers\",\n" +
                "                \"subscription_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscription\",\n" +
                "                \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/commits{/sha}\",\n" +
                "                \"git_commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/commits{/sha}\",\n" +
                "                \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/comments{/number}\",\n" +
                "                \"issue_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/comments{/number}\",\n" +
                "                \"contents_url\": \"https://api.github.com/repos/elastic/elasticsearch/contents/{+path}\",\n" +
                "                \"compare_url\": \"https://api.github.com/repos/elastic/elasticsearch/compare/{base}...{head}\",\n" +
                "                \"merges_url\": \"https://api.github.com/repos/elastic/elasticsearch/merges\",\n" +
                "                \"archive_url\": \"https://api.github.com/repos/elastic/elasticsearch/{archive_format}{/ref}\",\n" +
                "                \"downloads_url\": \"https://api.github.com/repos/elastic/elasticsearch/downloads\",\n" +
                "                \"issues_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues{/number}\",\n" +
                "                \"pulls_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls{/number}\",\n" +
                "                \"milestones_url\": \"https://api.github.com/repos/elastic/elasticsearch/milestones{/number}\",\n" +
                "                \"notifications_url\": \"https://api.github.com/repos/elastic/elasticsearch/notifications{?since,all,participating}\",\n" +
                "                \"labels_url\": \"https://api.github.com/repos/elastic/elasticsearch/labels{/name}\",\n" +
                "                \"releases_url\": \"https://api.github.com/repos/elastic/elasticsearch/releases{/id}\",\n" +
                "                \"deployments_url\": \"https://api.github.com/repos/elastic/elasticsearch/deployments\",\n" +
                "                \"created_at\": \"2010-02-08T13:20:56Z\",\n" +
                "                \"updated_at\": \"2018-03-06T17:23:54Z\",\n" +
                "                \"pushed_at\": \"2018-03-06T18:43:45Z\",\n" +
                "                \"git_url\": \"git://github.com/elastic/elasticsearch.git\",\n" +
                "                \"ssh_url\": \"git@github.com:elastic/elasticsearch.git\",\n" +
                "                \"clone_url\": \"https://github.com/elastic/elasticsearch.git\",\n" +
                "                \"svn_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "                \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "                \"size\": 391329,\n" +
                "                \"stargazers_count\": 29176,\n" +
                "                \"watchers_count\": 29176,\n" +
                "                \"language\": \"Java\",\n" +
                "                \"has_issues\": true,\n" +
                "                \"has_projects\": true,\n" +
                "                \"has_downloads\": true,\n" +
                "                \"has_wiki\": false,\n" +
                "                \"has_pages\": false,\n" +
                "                \"forks_count\": 10168,\n" +
                "                \"mirror_url\": null,\n" +
                "                \"archived\": false,\n" +
                "                \"open_issues_count\": 1394,\n" +
                "                \"license\": {\n" +
                "                    \"key\": \"apache-2.0\",\n" +
                "                    \"name\": \"Apache License 2.0\",\n" +
                "                    \"spdx_id\": \"Apache-2.0\",\n" +
                "                    \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "                },\n" +
                "                \"forks\": 10168,\n" +
                "                \"open_issues\": 1394,\n" +
                "                \"watchers\": 29176,\n" +
                "                \"default_branch\": \"master\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"_links\": {\n" +
                "            \"self\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28909\"\n" +
                "            },\n" +
                "            \"html\": {\n" +
                "                \"href\": \"https://github.com/elastic/elasticsearch/pull/28909\"\n" +
                "            },\n" +
                "            \"issue\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/28909\"\n" +
                "            },\n" +
                "            \"comments\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/28909/comments\"\n" +
                "            },\n" +
                "            \"review_comments\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28909/comments\"\n" +
                "            },\n" +
                "            \"review_comment\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\"\n" +
                "            },\n" +
                "            \"commits\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28909/commits\"\n" +
                "            },\n" +
                "            \"statuses\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/3add454763c49cbbd591c2f265df0485b1edfef3\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"author_association\": \"CONTRIBUTOR\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28902\",\n" +
                "        \"id\": 172762117,\n" +
                "        \"html_url\": \"https://github.com/elastic/elasticsearch/pull/28902\",\n" +
                "        \"diff_url\": \"https://github.com/elastic/elasticsearch/pull/28902.diff\",\n" +
                "        \"patch_url\": \"https://github.com/elastic/elasticsearch/pull/28902.patch\",\n" +
                "        \"issue_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/28902\",\n" +
                "        \"number\": 28902,\n" +
                "        \"state\": \"open\",\n" +
                "        \"locked\": false,\n" +
                "        \"title\": \"Add missing info about Homebrew installation\",\n" +
                "        \"user\": {\n" +
                "            \"login\": \"jrpool\",\n" +
                "            \"id\": 3364797,\n" +
                "            \"avatar_url\": \"https://avatars3.githubusercontent.com/u/3364797?v=4\",\n" +
                "            \"gravatar_id\": \"\",\n" +
                "            \"url\": \"https://api.github.com/users/jrpool\",\n" +
                "            \"html_url\": \"https://github.com/jrpool\",\n" +
                "            \"followers_url\": \"https://api.github.com/users/jrpool/followers\",\n" +
                "            \"following_url\": \"https://api.github.com/users/jrpool/following{/other_user}\",\n" +
                "            \"gists_url\": \"https://api.github.com/users/jrpool/gists{/gist_id}\",\n" +
                "            \"starred_url\": \"https://api.github.com/users/jrpool/starred{/owner}{/repo}\",\n" +
                "            \"subscriptions_url\": \"https://api.github.com/users/jrpool/subscriptions\",\n" +
                "            \"organizations_url\": \"https://api.github.com/users/jrpool/orgs\",\n" +
                "            \"repos_url\": \"https://api.github.com/users/jrpool/repos\",\n" +
                "            \"events_url\": \"https://api.github.com/users/jrpool/events{/privacy}\",\n" +
                "            \"received_events_url\": \"https://api.github.com/users/jrpool/received_events\",\n" +
                "            \"type\": \"User\",\n" +
                "            \"site_admin\": false\n" +
                "        },\n" +
                "        \"body\": \"A better fix is probably to make the above change and also to put the “Successfully running node” section into a different file and refer users to it as the next file at the end of each installation section. It is currently difficult to ascertain that that section pertains to all of the installation platforms and methods, not only to the MSI Windows one.\\r\\n\\r\\n<!--\\r\\nThank you for your interest in and contributing to Elasticsearch! There\\r\\nare a few simple things to check before submitting your pull request\\r\\nthat can help with the review process. You should delete these items\\r\\nfrom your submission, but they are here to help bring them to your\\r\\nattention.\\r\\n-->\\r\\n\\r\\n- Have you signed the [contributor license agreement](https://www.elastic.co/contributor-agreement)?\\r\\n- Have you followed the [contributor guidelines](https://github.com/elastic/elasticsearch/blob/master/CONTRIBUTING.md)?\\r\\n- If submitting code, have you built your formula locally prior to submission with `gradle check`?\\r\\n- If submitting code, is your pull request against master? Unless there is a good reason otherwise, we prefer pull requests against master and will backport as needed.\\r\\n- If submitting code, have you checked that your submission is for an [OS that we support](https://www.elastic.co/support/matrix#show_os)?\\r\\n- If you are submitting this code for a class then read our [policy](https://github.com/elastic/elasticsearch/blob/master/CONTRIBUTING.md#contributing-as-part-of-a-class) for that.\\r\\n\",\n" +
                "        \"created_at\": \"2018-03-05T02:43:05Z\",\n" +
                "        \"updated_at\": \"2018-03-06T14:47:55Z\",\n" +
                "        \"closed_at\": null,\n" +
                "        \"merged_at\": null,\n" +
                "        \"merge_commit_sha\": \"9d7a1e766ad8d53c9f0538fdf2a7fde64ad8ce4d\",\n" +
                "        \"assignee\": null,\n" +
                "        \"assignees\": [],\n" +
                "        \"requested_reviewers\": [],\n" +
                "        \"requested_teams\": [],\n" +
                "        \"labels\": [\n" +
                "            {\n" +
                "                \"id\": 114977275,\n" +
                "                \"url\": \"https://api.github.com/repos/elastic/elasticsearch/labels/:Core/Packaging\",\n" +
                "                \"name\": \":Core/Packaging\",\n" +
                "                \"color\": \"0e8a16\",\n" +
                "                \"default\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 94283388,\n" +
                "                \"url\": \"https://api.github.com/repos/elastic/elasticsearch/labels/review\",\n" +
                "                \"name\": \"review\",\n" +
                "                \"color\": \"0052cc\",\n" +
                "                \"default\": false\n" +
                "            }\n" +
                "        ],\n" +
                "        \"milestone\": null,\n" +
                "        \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28902/commits\",\n" +
                "        \"review_comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28902/comments\",\n" +
                "        \"review_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/28902/comments\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/b773891ecb01ada128d73b0b299a0641f029a2b0\",\n" +
                "        \"head\": {\n" +
                "            \"label\": \"jrpool:patch-1\",\n" +
                "            \"ref\": \"patch-1\",\n" +
                "            \"sha\": \"b773891ecb01ada128d73b0b299a0641f029a2b0\",\n" +
                "            \"user\": {\n" +
                "                \"login\": \"jrpool\",\n" +
                "                \"id\": 3364797,\n" +
                "                \"avatar_url\": \"https://avatars3.githubusercontent.com/u/3364797?v=4\",\n" +
                "                \"gravatar_id\": \"\",\n" +
                "                \"url\": \"https://api.github.com/users/jrpool\",\n" +
                "                \"html_url\": \"https://github.com/jrpool\",\n" +
                "                \"followers_url\": \"https://api.github.com/users/jrpool/followers\",\n" +
                "                \"following_url\": \"https://api.github.com/users/jrpool/following{/other_user}\",\n" +
                "                \"gists_url\": \"https://api.github.com/users/jrpool/gists{/gist_id}\",\n" +
                "                \"starred_url\": \"https://api.github.com/users/jrpool/starred{/owner}{/repo}\",\n" +
                "                \"subscriptions_url\": \"https://api.github.com/users/jrpool/subscriptions\",\n" +
                "                \"organizations_url\": \"https://api.github.com/users/jrpool/orgs\",\n" +
                "                \"repos_url\": \"https://api.github.com/users/jrpool/repos\",\n" +
                "                \"events_url\": \"https://api.github.com/users/jrpool/events{/privacy}\",\n" +
                "                \"received_events_url\": \"https://api.github.com/users/jrpool/received_events\",\n" +
                "                \"type\": \"User\",\n" +
                "                \"site_admin\": false\n" +
                "            },\n" +
                "            \"repo\": {\n" +
                "                \"id\": 123854246,\n" +
                "                \"name\": \"elasticsearch\",\n" +
                "                \"full_name\": \"jrpool/elasticsearch\",\n" +
                "                \"owner\": {\n" +
                "                    \"login\": \"jrpool\",\n" +
                "                    \"id\": 3364797,\n" +
                "                    \"avatar_url\": \"https://avatars3.githubusercontent.com/u/3364797?v=4\",\n" +
                "                    \"gravatar_id\": \"\",\n" +
                "                    \"url\": \"https://api.github.com/users/jrpool\",\n" +
                "                    \"html_url\": \"https://github.com/jrpool\",\n" +
                "                    \"followers_url\": \"https://api.github.com/users/jrpool/followers\",\n" +
                "                    \"following_url\": \"https://api.github.com/users/jrpool/following{/other_user}\",\n" +
                "                    \"gists_url\": \"https://api.github.com/users/jrpool/gists{/gist_id}\",\n" +
                "                    \"starred_url\": \"https://api.github.com/users/jrpool/starred{/owner}{/repo}\",\n" +
                "                    \"subscriptions_url\": \"https://api.github.com/users/jrpool/subscriptions\",\n" +
                "                    \"organizations_url\": \"https://api.github.com/users/jrpool/orgs\",\n" +
                "                    \"repos_url\": \"https://api.github.com/users/jrpool/repos\",\n" +
                "                    \"events_url\": \"https://api.github.com/users/jrpool/events{/privacy}\",\n" +
                "                    \"received_events_url\": \"https://api.github.com/users/jrpool/received_events\",\n" +
                "                    \"type\": \"User\",\n" +
                "                    \"site_admin\": false\n" +
                "                },\n" +
                "                \"private\": false,\n" +
                "                \"html_url\": \"https://github.com/jrpool/elasticsearch\",\n" +
                "                \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "                \"fork\": true,\n" +
                "                \"url\": \"https://api.github.com/repos/jrpool/elasticsearch\",\n" +
                "                \"forks_url\": \"https://api.github.com/repos/jrpool/elasticsearch/forks\",\n" +
                "                \"keys_url\": \"https://api.github.com/repos/jrpool/elasticsearch/keys{/key_id}\",\n" +
                "                \"collaborators_url\": \"https://api.github.com/repos/jrpool/elasticsearch/collaborators{/collaborator}\",\n" +
                "                \"teams_url\": \"https://api.github.com/repos/jrpool/elasticsearch/teams\",\n" +
                "                \"hooks_url\": \"https://api.github.com/repos/jrpool/elasticsearch/hooks\",\n" +
                "                \"issue_events_url\": \"https://api.github.com/repos/jrpool/elasticsearch/issues/events{/number}\",\n" +
                "                \"events_url\": \"https://api.github.com/repos/jrpool/elasticsearch/events\",\n" +
                "                \"assignees_url\": \"https://api.github.com/repos/jrpool/elasticsearch/assignees{/user}\",\n" +
                "                \"branches_url\": \"https://api.github.com/repos/jrpool/elasticsearch/branches{/branch}\",\n" +
                "                \"tags_url\": \"https://api.github.com/repos/jrpool/elasticsearch/tags\",\n" +
                "                \"blobs_url\": \"https://api.github.com/repos/jrpool/elasticsearch/git/blobs{/sha}\",\n" +
                "                \"git_tags_url\": \"https://api.github.com/repos/jrpool/elasticsearch/git/tags{/sha}\",\n" +
                "                \"git_refs_url\": \"https://api.github.com/repos/jrpool/elasticsearch/git/refs{/sha}\",\n" +
                "                \"trees_url\": \"https://api.github.com/repos/jrpool/elasticsearch/git/trees{/sha}\",\n" +
                "                \"statuses_url\": \"https://api.github.com/repos/jrpool/elasticsearch/statuses/{sha}\",\n" +
                "                \"languages_url\": \"https://api.github.com/repos/jrpool/elasticsearch/languages\",\n" +
                "                \"stargazers_url\": \"https://api.github.com/repos/jrpool/elasticsearch/stargazers\",\n" +
                "                \"contributors_url\": \"https://api.github.com/repos/jrpool/elasticsearch/contributors\",\n" +
                "                \"subscribers_url\": \"https://api.github.com/repos/jrpool/elasticsearch/subscribers\",\n" +
                "                \"subscription_url\": \"https://api.github.com/repos/jrpool/elasticsearch/subscription\",\n" +
                "                \"commits_url\": \"https://api.github.com/repos/jrpool/elasticsearch/commits{/sha}\",\n" +
                "                \"git_commits_url\": \"https://api.github.com/repos/jrpool/elasticsearch/git/commits{/sha}\",\n" +
                "                \"comments_url\": \"https://api.github.com/repos/jrpool/elasticsearch/comments{/number}\",\n" +
                "                \"issue_comment_url\": \"https://api.github.com/repos/jrpool/elasticsearch/issues/comments{/number}\",\n" +
                "                \"contents_url\": \"https://api.github.com/repos/jrpool/elasticsearch/contents/{+path}\",\n" +
                "                \"compare_url\": \"https://api.github.com/repos/jrpool/elasticsearch/compare/{base}...{head}\",\n" +
                "                \"merges_url\": \"https://api.github.com/repos/jrpool/elasticsearch/merges\",\n" +
                "                \"archive_url\": \"https://api.github.com/repos/jrpool/elasticsearch/{archive_format}{/ref}\",\n" +
                "                \"downloads_url\": \"https://api.github.com/repos/jrpool/elasticsearch/downloads\",\n" +
                "                \"issues_url\": \"https://api.github.com/repos/jrpool/elasticsearch/issues{/number}\",\n" +
                "                \"pulls_url\": \"https://api.github.com/repos/jrpool/elasticsearch/pulls{/number}\",\n" +
                "                \"milestones_url\": \"https://api.github.com/repos/jrpool/elasticsearch/milestones{/number}\",\n" +
                "                \"notifications_url\": \"https://api.github.com/repos/jrpool/elasticsearch/notifications{?since,all,participating}\",\n" +
                "                \"labels_url\": \"https://api.github.com/repos/jrpool/elasticsearch/labels{/name}\",\n" +
                "                \"releases_url\": \"https://api.github.com/repos/jrpool/elasticsearch/releases{/id}\",\n" +
                "                \"deployments_url\": \"https://api.github.com/repos/jrpool/elasticsearch/deployments\",\n" +
                "                \"created_at\": \"2018-03-05T02:36:46Z\",\n" +
                "                \"updated_at\": \"2018-03-05T02:37:21Z\",\n" +
                "                \"pushed_at\": \"2018-03-05T03:22:03Z\",\n" +
                "                \"git_url\": \"git://github.com/jrpool/elasticsearch.git\",\n" +
                "                \"ssh_url\": \"git@github.com:jrpool/elasticsearch.git\",\n" +
                "                \"clone_url\": \"https://github.com/jrpool/elasticsearch.git\",\n" +
                "                \"svn_url\": \"https://github.com/jrpool/elasticsearch\",\n" +
                "                \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "                \"size\": 390837,\n" +
                "                \"stargazers_count\": 0,\n" +
                "                \"watchers_count\": 0,\n" +
                "                \"language\": \"Java\",\n" +
                "                \"has_issues\": false,\n" +
                "                \"has_projects\": true,\n" +
                "                \"has_downloads\": true,\n" +
                "                \"has_wiki\": false,\n" +
                "                \"has_pages\": false,\n" +
                "                \"forks_count\": 0,\n" +
                "                \"mirror_url\": null,\n" +
                "                \"archived\": false,\n" +
                "                \"open_issues_count\": 0,\n" +
                "                \"license\": {\n" +
                "                    \"key\": \"apache-2.0\",\n" +
                "                    \"name\": \"Apache License 2.0\",\n" +
                "                    \"spdx_id\": \"Apache-2.0\",\n" +
                "                    \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "                },\n" +
                "                \"forks\": 0,\n" +
                "                \"open_issues\": 0,\n" +
                "                \"watchers\": 0,\n" +
                "                \"default_branch\": \"master\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"base\": {\n" +
                "            \"label\": \"elastic:6.2\",\n" +
                "            \"ref\": \"6.2\",\n" +
                "            \"sha\": \"da8c554999aa63e9edeb8abd6b1c05c390accfd5\",\n" +
                "            \"user\": {\n" +
                "                \"login\": \"elastic\",\n" +
                "                \"id\": 6764390,\n" +
                "                \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "                \"gravatar_id\": \"\",\n" +
                "                \"url\": \"https://api.github.com/users/elastic\",\n" +
                "                \"html_url\": \"https://github.com/elastic\",\n" +
                "                \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "                \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "                \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "                \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "                \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "                \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "                \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "                \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "                \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "                \"type\": \"Organization\",\n" +
                "                \"site_admin\": false\n" +
                "            },\n" +
                "            \"repo\": {\n" +
                "                \"id\": 507775,\n" +
                "                \"name\": \"elasticsearch\",\n" +
                "                \"full_name\": \"elastic/elasticsearch\",\n" +
                "                \"owner\": {\n" +
                "                    \"login\": \"elastic\",\n" +
                "                    \"id\": 6764390,\n" +
                "                    \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "                    \"gravatar_id\": \"\",\n" +
                "                    \"url\": \"https://api.github.com/users/elastic\",\n" +
                "                    \"html_url\": \"https://github.com/elastic\",\n" +
                "                    \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "                    \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "                    \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "                    \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "                    \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "                    \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "                    \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "                    \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "                    \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "                    \"type\": \"Organization\",\n" +
                "                    \"site_admin\": false\n" +
                "                },\n" +
                "                \"private\": false,\n" +
                "                \"html_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "                \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "                \"fork\": false,\n" +
                "                \"url\": \"https://api.github.com/repos/elastic/elasticsearch\",\n" +
                "                \"forks_url\": \"https://api.github.com/repos/elastic/elasticsearch/forks\",\n" +
                "                \"keys_url\": \"https://api.github.com/repos/elastic/elasticsearch/keys{/key_id}\",\n" +
                "                \"collaborators_url\": \"https://api.github.com/repos/elastic/elasticsearch/collaborators{/collaborator}\",\n" +
                "                \"teams_url\": \"https://api.github.com/repos/elastic/elasticsearch/teams\",\n" +
                "                \"hooks_url\": \"https://api.github.com/repos/elastic/elasticsearch/hooks\",\n" +
                "                \"issue_events_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/events{/number}\",\n" +
                "                \"events_url\": \"https://api.github.com/repos/elastic/elasticsearch/events\",\n" +
                "                \"assignees_url\": \"https://api.github.com/repos/elastic/elasticsearch/assignees{/user}\",\n" +
                "                \"branches_url\": \"https://api.github.com/repos/elastic/elasticsearch/branches{/branch}\",\n" +
                "                \"tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/tags\",\n" +
                "                \"blobs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/blobs{/sha}\",\n" +
                "                \"git_tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/tags{/sha}\",\n" +
                "                \"git_refs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/refs{/sha}\",\n" +
                "                \"trees_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/trees{/sha}\",\n" +
                "                \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/{sha}\",\n" +
                "                \"languages_url\": \"https://api.github.com/repos/elastic/elasticsearch/languages\",\n" +
                "                \"stargazers_url\": \"https://api.github.com/repos/elastic/elasticsearch/stargazers\",\n" +
                "                \"contributors_url\": \"https://api.github.com/repos/elastic/elasticsearch/contributors\",\n" +
                "                \"subscribers_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscribers\",\n" +
                "                \"subscription_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscription\",\n" +
                "                \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/commits{/sha}\",\n" +
                "                \"git_commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/commits{/sha}\",\n" +
                "                \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/comments{/number}\",\n" +
                "                \"issue_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/comments{/number}\",\n" +
                "                \"contents_url\": \"https://api.github.com/repos/elastic/elasticsearch/contents/{+path}\",\n" +
                "                \"compare_url\": \"https://api.github.com/repos/elastic/elasticsearch/compare/{base}...{head}\",\n" +
                "                \"merges_url\": \"https://api.github.com/repos/elastic/elasticsearch/merges\",\n" +
                "                \"archive_url\": \"https://api.github.com/repos/elastic/elasticsearch/{archive_format}{/ref}\",\n" +
                "                \"downloads_url\": \"https://api.github.com/repos/elastic/elasticsearch/downloads\",\n" +
                "                \"issues_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues{/number}\",\n" +
                "                \"pulls_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls{/number}\",\n" +
                "                \"milestones_url\": \"https://api.github.com/repos/elastic/elasticsearch/milestones{/number}\",\n" +
                "                \"notifications_url\": \"https://api.github.com/repos/elastic/elasticsearch/notifications{?since,all,participating}\",\n" +
                "                \"labels_url\": \"https://api.github.com/repos/elastic/elasticsearch/labels{/name}\",\n" +
                "                \"releases_url\": \"https://api.github.com/repos/elastic/elasticsearch/releases{/id}\",\n" +
                "                \"deployments_url\": \"https://api.github.com/repos/elastic/elasticsearch/deployments\",\n" +
                "                \"created_at\": \"2010-02-08T13:20:56Z\",\n" +
                "                \"updated_at\": \"2018-03-06T17:23:54Z\",\n" +
                "                \"pushed_at\": \"2018-03-06T18:43:45Z\",\n" +
                "                \"git_url\": \"git://github.com/elastic/elasticsearch.git\",\n" +
                "                \"ssh_url\": \"git@github.com:elastic/elasticsearch.git\",\n" +
                "                \"clone_url\": \"https://github.com/elastic/elasticsearch.git\",\n" +
                "                \"svn_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "                \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "                \"size\": 391329,\n" +
                "                \"stargazers_count\": 29176,\n" +
                "                \"watchers_count\": 29176,\n" +
                "                \"language\": \"Java\",\n" +
                "                \"has_issues\": true,\n" +
                "                \"has_projects\": true,\n" +
                "                \"has_downloads\": true,\n" +
                "                \"has_wiki\": false,\n" +
                "                \"has_pages\": false,\n" +
                "                \"forks_count\": 10168,\n" +
                "                \"mirror_url\": null,\n" +
                "                \"archived\": false,\n" +
                "                \"open_issues_count\": 1394,\n" +
                "                \"license\": {\n" +
                "                    \"key\": \"apache-2.0\",\n" +
                "                    \"name\": \"Apache License 2.0\",\n" +
                "                    \"spdx_id\": \"Apache-2.0\",\n" +
                "                    \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "                },\n" +
                "                \"forks\": 10168,\n" +
                "                \"open_issues\": 1394,\n" +
                "                \"watchers\": 29176,\n" +
                "                \"default_branch\": \"master\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"_links\": {\n" +
                "            \"self\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28902\"\n" +
                "            },\n" +
                "            \"html\": {\n" +
                "                \"href\": \"https://github.com/elastic/elasticsearch/pull/28902\"\n" +
                "            },\n" +
                "            \"issue\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/28902\"\n" +
                "            },\n" +
                "            \"comments\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/28902/comments\"\n" +
                "            },\n" +
                "            \"review_comments\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28902/comments\"\n" +
                "            },\n" +
                "            \"review_comment\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\"\n" +
                "            },\n" +
                "            \"commits\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/28902/commits\"\n" +
                "            },\n" +
                "            \"statuses\": {\n" +
                "                \"href\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/b773891ecb01ada128d73b0b299a0641f029a2b0\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"author_association\": \"CONTRIBUTOR\"\n" +
                "    }\n" +
                "]"
    }
}