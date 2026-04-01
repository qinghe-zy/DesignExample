param(
    [Parameter(Mandatory = $true)]
    [string]$TemplateName,

    [string]$RootPath = (Resolve-Path (Join-Path $PSScriptRoot "..")).Path
)

$normalizedName = $TemplateName.Trim().ToLower()

if ($normalizedName -notmatch '^[a-z0-9]+(-[a-z0-9]+)*$') {
    throw "TemplateName must use lowercase kebab-case, for example: student-management"
}

$projectPath = Join-Path $RootPath ("projects\" + $normalizedName)

if (Test-Path $projectPath) {
    throw "Target project already exists: $projectPath"
}

$directories = @(
    $projectPath,
    (Join-Path $projectPath "backend"),
    (Join-Path $projectPath "frontend"),
    (Join-Path $projectPath "sql"),
    (Join-Path $projectPath "docs")
)

foreach ($directory in $directories) {
    New-Item -ItemType Directory -Path $directory -Force | Out-Null
}

$readmePath = Join-Path $projectPath "README.md"
$readme = @"
# $normalizedName

该项目已基于当前 Projectexample 模板工厂结构完成基础初始化。

## 建议下一步

1. 阅读 ../../blueprints/base-admin-template
2. 按当前基础底座补充后端和前端代码
3. 在 ./sql 下补充数据库初始化文件
4. 在 ./docs 下补充模块说明与扩展说明

## 说明

- 当前目录壳层刻意保持精简，便于后续从共享底座继续派生。
- 当项目具备明确业务含义后，应继续更新本 README。
"@

Set-Content -Path $readmePath -Value $readme -Encoding UTF8

Write-Host "Initialized template shell at $projectPath"
