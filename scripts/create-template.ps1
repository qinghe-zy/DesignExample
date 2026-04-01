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

This project was initialized from the current Projectexample template factory structure.

## Suggested Next Steps

1. Review ../../blueprints/base-admin-template
2. Add backend and frontend code using the current baseline
3. Add SQL initialization files under ./sql
4. Document business modules and extension points under ./docs

## Notes

- This project shell is intentionally minimal so future template families can specialize from the shared baseline.
- Update this README as the template gains concrete business meaning.
"@

Set-Content -Path $readmePath -Value $readme -Encoding UTF8

Write-Host "Initialized template shell at $projectPath"
